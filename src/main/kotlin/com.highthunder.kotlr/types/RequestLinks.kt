package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * RequestLinks - A class to encode the various request links that Tumblr will include in responses.
 *
 * @author highthunder
 * @since 2020-08-30
 * @version 1.0.0
 *
 * @param next A link to the next request in a series.
 * @param prev A link to the previous request in a series.
 */
@JsonClass(generateAdapter = true)
public data class RequestLinks constructor(
    val next: RequestLink? = null,
    val prev: RequestLink? = null,
    @Json(name = "terms_of_service")
    val termsOfService: RequestLink? = null,
)