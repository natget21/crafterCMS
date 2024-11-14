import groovy.xml.XmlSlurper

// Ensure contentLoader is available
def contentLoader = binding.getVariable("contentLoader") ?: applicationContext.getBean("contentLoader")

def fetchCategoryDetails(categoryPath) {
    def categoryFile = contentLoader.loadContent(categoryPath)
    if (!categoryFile) throw new Exception("Category not found")

    def xmlContent = new XmlSlurper().parseText(categoryFile.contentAsString)
    return [
        name: xmlContent.categoryname_s?.text(),
        description: xmlContent.description?.text()
    ]
}

def fetchSubCategories() {
    def subCategories = contentLoader.loadContent("/site/components/sub_categories")
    def subCategoryList = []

    if (subCategories) {
        subCategories.each { subCategory ->
            def details = [:]
            details['name'] = subCategory.subCategoryName_s?.text()

            // Fetch referenced categories
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

// Main API response
def result = fetchSubCategories()
return result