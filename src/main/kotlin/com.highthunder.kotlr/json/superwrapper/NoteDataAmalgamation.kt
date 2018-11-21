package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.NoteData.*
import com.highthunder.kotlr.types.content.TextFormat
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * NoteDataAmalgamation - A class to hold every possible field for [NoteData] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param type The type of this note.
 * @param timestamp TODO: Documentation
 * @param blogName TODO: Documentation
 * @param blogUuid TODO: Documentation
 * @param blogUrl TODO: Documentation
 * @param blogFollowed TODO: Documentation
 * @param avatarShape TODO: Documentation
 * @param addedText TODO: Documentation
 * @param postId TODO: Documentation
 * @param reblogParentBlogName TODO: Documentation
 * @param replyText TODO: Documentation
 * @param formatting TODO: Documentation
 * @param canBlock TODO: Documentation
 * @param postAttributionType TODO: Documentation
 * @param postAttributionTypeName TODO: Documentation
 * @param photoUrl TODO: Documentation
 * @param photoWidth TODO: Documentation
 * @param photoHeight TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class NoteDataAmalgamation(
    @Json(name = "type")
    var type: String? = null,
    @Json(name = "timestamp")
    var timestamp: Long? = null,
    @Json(name = "blog_name")
    var blogName: String? = null,
    @Json(name = "blog_uuid")
    var blogUuid: String? = null,
    @Json(name = "blog_url")
    var blogUrl: String? = null,
    @Json(name = "followed")
    var blogFollowed: Boolean? = null,
    @Json(name = "avatar_shape")
    var avatarShape: String? = null,
    @Json(name = "added_text")
    var addedText: String? = null,
    @Json(name = "post_id")
    var postId: String? = null,
    @Json(name = "reblog_parent_blog_name")
    var reblogParentBlogName: String? = null,
    @Json(name = "reply_text")
    var replyText: String? = null,
    @Json(name = "formatting")
    var formatting: List<TextFormat>? = null,
    @Json(name = "can_block")
    var canBlock: Boolean? = null,
    @Json(name = "post_attribution_type")
    var postAttributionType: String? = null,
    @Json(name = "post_attribution_type_name")
    var postAttributionTypeName: String? = null,
    @Json(name = "photo_url")
    var photoUrl: String? = null,
    @Json(name = "photo_width")
    var photoWidth: Int? = null,
    @Json(name = "photo_height")
    var photoHeight: Int? = null
) {

    // TODO: To and from NoteDataAmalgamation

    constructor(note: Like) : this(Like.KEY)
    constructor(note: Reblog) : this(Reblog.KEY)
    constructor(note: Posted) : this(Posted.KEY)
    constructor(note: Reply) : this(Reply.KEY)
    constructor(note: Attribution) : this(Attribution.KEY)

    /**
     * TODO: Documentation
     */
    fun toLike(): Like = Like()

    /**
     * TODO: Documentation
     */
    fun toReblog(): Reblog = Reblog()

    /**
     * TODO: Documentation
     */
    fun toPosted(): Posted = Posted()

    /**
     * TODO: Documentation
     */
    fun toReply(): Reply = Reply()

    /**
     * TODO: Documentation
     */
    fun toAttribution(): Attribution = Attribution()

}