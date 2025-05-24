package com.d4c.assignment

import com.d4c.assignment.models.Product
import com.d4c.assignment.models.ProductCategory
import com.d4c.assignment.models.PromoBannerData

val SamplePromoBannersDataList = listOf(
    PromoBannerData("GET 20% OFF", "Get 20% off", "12-16 October"),
    PromoBannerData("FLASH DEAL", "Limited time offer", "17-20 October"),
    PromoBannerData("BOGO DEAL", "Buy one get one free", "10-28 October")
)

val SampleProductCategories = listOf(
    ProductCategory("Cleaners", R.drawable.img_dummy_product_category),
    ProductCategory("Toner", R.drawable.img_dummy_product_category),
    ProductCategory("Serums", R.drawable.img_dummy_product_category),
    ProductCategory("Moisturisers", R.drawable.img_dummy_product_category),
    ProductCategory("Sunscreen", R.drawable.img_dummy_product_category),
    ProductCategory("Cleaners", R.drawable.img_dummy_product_category),
    ProductCategory("Serums", R.drawable.img_dummy_product_category),
    ProductCategory("Sunscreen", R.drawable.img_dummy_product_category)
)

val SampleProducts = listOf(
    Product(
        imageRes = R.drawable.img_dummy_product,
        title = "clencera",
        description = "French clay and algae-powered cleanser",
        useCase = "Skin Tightness",
        skinType = "Dry & Dehydrated Skin",
        price = 355.20f,
        originalPrice = 444.00f,
        reviews = 249,
        rating = 5f,
        bestSeller = true,
        inStock = true,
        isWishlisted = true
    ),
    Product(
        imageRes = R.drawable.img_dummy_product,
        title = "glow",
        description = "Glow-enhancing serum with Camellia + Vitamin C",
        useCase = "Dull & Uneven Tone",
        skinType = "All Skin Types",
        price = 410.00f,
        originalPrice = 499.00f,
        reviews = 180,
        rating = 4.5f,
        bestSeller = false,
        inStock = true,
        isWishlisted = false
    ),
    Product(
        imageRes = R.drawable.img_dummy_product,
        title = "glow",
        description = "Glow-enhancing serum with Camellia + Vitamin C",
        useCase = "Dry & Dehydrated Skin",
        skinType = "All Skin Types",
        price = 410.00f,
        originalPrice = 499.00f,
        reviews = 180,
        rating = 4.5f,
        bestSeller = false,
        inStock = false,
        isWishlisted = false
    )
)


val SampleProduct =  Product(
    imageRes = R.drawable.img_dummy_product,
    title = "clencera",
    description = "French clay and algae-powered cleanser",
    useCase = "Skin Tightness",
    skinType = "Dry & Dehydrated Skin",
    price = 355.20f,
    originalPrice = 444.00f,
    reviews = 249,
    rating = 5f,
    bestSeller = true,
    inStock = true,
    isWishlisted = true
)