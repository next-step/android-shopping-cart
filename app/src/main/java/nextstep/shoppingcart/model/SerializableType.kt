package nextstep.shoppingcart.model

import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

inline fun <reified T : Any> serializableType(
    isNullableAllowed: Boolean = false,
    json: Json = Json,
) = object : NavType<T>(isNullableAllowed = isNullableAllowed) {
    override fun get(bundle: Bundle, key: String) =
        bundle.getString(key)?.let<String, T> {
            val decodedString = URLDecoder.decode(it, StandardCharsets.UTF_8.toString())
            json.decodeFromString(decodedString)
        }

    override fun parseValue(value: String): T {
        val decodedString = URLDecoder.decode(value, StandardCharsets.UTF_8.toString())
        return json.decodeFromString(decodedString)
    }

    override fun serializeAsValue(value: T): String {
        val jsonString = json.encodeToString(value)
        return URLEncoder.encode(jsonString, StandardCharsets.UTF_8.toString())
    }

    override fun put(bundle: Bundle, key: String, value: T) {
        val jsonString = json.encodeToString(value)
        val encodedString = URLEncoder.encode(jsonString, StandardCharsets.UTF_8.toString())
        bundle.putString(key, encodedString)
    }
}