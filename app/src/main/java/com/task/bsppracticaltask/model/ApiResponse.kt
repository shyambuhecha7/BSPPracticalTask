package com.task.bsppracticaltask.model

data class ApiResponse(
    val success: Boolean,
    val api_log_id: Long,
    val request_uuid: String,
    val generated: String,
    val page: Page
)

data class Page(
    val id: Int,
    val name: String,
    val elements: List<Element>,
    val pill_filters: List<PillFilter>
)

data class Element(
    val id: Int,
    val element_type: String,
    val header: String,
    val subheader: String,
    val sku: String,
    val media_data: MediaData,
    val title: String,
    val topics: List<Topic>,
    val subtitles: List<Subtitle>,
    val languages: List<Language>,
    val publisher: Publisher,
    val mobile_image_url: String,
    val tablet_image_url: String,
    val additional_field_1: String,
    val additional_field_2: String
)

data class MediaData(
    val authors: List<Author>,
    val book_id: Long,
    val categories: List<Category>,
    val cover: Cover,
    val description: String,
    val media_id: Long,
    val product_properties: List<ProductProperty>,
    val ebook: Ebook
)

data class Author(
    val id: Int,
    val first_name: String,
    val last_name: String
)

data class Category(
    val name: String,
    val id: Int,
    val description: String
)

data class Cover(
    val full_url: String,
    val thumbnail_url: String,
    val detail_url: String,
    val listing_url: String
)

data class ProductProperty(
    val property_id: Int,
    val id: Int,
    val property_name: String,
    val value: String
)

data class Ebook(
    val properties: List<EbookProperty>,
    val subscription_plan_ids: List<String>,
    val book_id: Long,
    val created_at: String,
    val media_id: Long,
    val pretty_price: String,
    val price: Double,
    val sample_available: Boolean,
    val sku: String,
    val updated_at: String,
    val version: Int,
    val release_date: String?,
    val scriptures: Boolean,
    val view_mode: String,
    val user_info: UserInfo
)

data class EbookProperty(
    val property_id: Int,
    val id: Int,
    val property_name: String,
    val value: String
)

data class UserInfo(
    val in_library: Boolean,
    val purchased: Boolean,
    val subscribed: Boolean,
    val subscribable: Boolean,
    val expires_at: String,
    val sample: Boolean,
    val last_position: String,
    val favorite: Boolean,
    val can_buy_now: Boolean,
    val completed: Boolean,
    val archived: Boolean
)

data class Topic(
    val name: String,
    val id: Int,
    val description: String
)

data class Subtitle(
    val type: String,
    val value: String
)

data class Language(
    val name: String,
    val iso: String
)

data class Publisher(
    val id: String,
    val name: String
)

data class PillFilter(
    val id: Int,
    val filter_name: String,
    val values: List<String>
)
