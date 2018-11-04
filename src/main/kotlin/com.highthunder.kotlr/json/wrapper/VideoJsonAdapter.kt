package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.legacy.Video
import com.squareup.moshi.*

/**
 * VideoJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class VideoJsonAdapter(moshi: Moshi): JsonAdapter<Video>() {
    private val options: JsonReader.Options = JsonReader.Options.of("width", "embed_code")

    private val nullableIntAdapter: JsonAdapter<Int?> =
            moshi.adapter<Int?>(Int::class.javaObjectType, kotlin.collections.emptySet(), "width")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "embed_code")

    private val nullableBooleanAdapter: JsonAdapter<Boolean?> =
            moshi.adapter<Boolean?>(Boolean::class.java, kotlin.collections.emptySet(), "embed_code")

    override fun toString(): String = "GeneratedJsonAdapter(Video)"

    @FromJson
    override fun fromJson(reader: JsonReader): Video {
        var width: Int? = null
        var widthSet: Boolean = false
        var embedCode: String? = null
        var embedCodeSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    width = nullableIntAdapter.fromJson(reader)
                    widthSet = true
                }
                1 ->  {
                    if (reader.peek() == JsonReader.Token.STRING) {
                        embedCode = nullableStringAdapter.fromJson(reader)
                        embedCodeSet = true
                    } else {
                        // Tumblr gave us something else, skip it.
                        nullableBooleanAdapter.fromJson(reader)
                    }
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = Video()
        result = result.copy(
                width = if (widthSet) width else result.width,
                embedCode = if (embedCodeSet) embedCode else result.embedCode)
        return result
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: Video?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("width")
        nullableIntAdapter.toJson(writer, value.width)
        writer.name("embed_code")
        nullableStringAdapter.toJson(writer, value.embedCode)
        writer.endObject()
    }
}