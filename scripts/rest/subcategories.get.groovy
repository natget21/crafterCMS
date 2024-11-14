import groovy.xml.XmlSlurper

// Ensure siteItemService is available for content fetching
def siteItemService = binding.getVariable("siteItemService") ?: applicationContext?.getBean("siteItemService")

if (!siteItemService) {
    throw new RuntimeException("siteItemService is not available")
}

def fetchCategoryDetails(categoryPath) {
    // Load the category content using siteItemService
    def categoryItem = siteItemService.getSiteItem(categoryPath)
    if (!categoryItem) throw new Exception("Category not found at path: " + categoryPath)

    // Parse the XML content to extract category details
    def xmlContent = new XmlSlurper().parseText(categoryItem.contentAsString)
    return [
        name: xmlContent.categoryname_s?.text(),
        description: xmlContent.description?.text()
    ]
}

def fetchSubCategories() {
    // Load the subcategories content using siteItemService
    def subCategoriesItem = siteItemService.getSiteItem("/site/components/sub_categories")
    def subCategoryList = []

    if (subCategoriesItem) {
        def subCategories = new XmlSlurper().parseText(subCategoriesItem.contentAsString)

        subCategories.each { subCategory ->
            def details = [:]
            details['name'] = subCategory.subCategoryName_s?.text()

            // Fetch the referenced categories for this subcategory
            def categories = []
            subCategory.category_o?.item?.each { item ->
                def categoryDetails = fetchCategoryDetails(item.key.text())
                categories << categoryDetails
            }
            details['categories'] = categories
            subCategoryList << details
        }
    }
    return subCategoryList
}

// Fetch the subcategories and return the result
def result = fetchSubCategories()
return result