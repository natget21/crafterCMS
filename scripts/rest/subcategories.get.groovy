// def subCategoriesItem = siteItemService.getSiteItem("/site/components/sub_categories");
// return subCategoriesItem;

// def siteTree = siteItemService.getSiteTree("/site/components/sub_categories", -1)
// def subCategoryList = []
// if (siteTree) {
//     def items = siteTree.childItems;
//     items.each { siteItem ->
//         subCategoryList.add(siteItem);
//     }
//     return subCategoryList;
// }

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
    // Fetch the subcategories folder item
    def siteTree = siteItemService.getSiteTree("/site/components/sub_categories", -1)
    def subCategoryList = []

    if (siteTree && siteTree.childItems) {
        siteTree.childItems.each { siteItem ->
            def details = [
                name: siteItem.descriptorDom?.component?.subCategoryName_s,
                description: siteItem.descriptorDom?.component?.description
            ]

            // Fetch additional category details for each item in category_o
            def categories = []
            // siteItem.descriptorDom?.component?.category_o?.item?.each { categoryItem ->
            //     def categoryPath = categoryItem.key.text()
            //     def categoryDetails = fetchCategoryDetails(categoryPath)
                
            //     // Include the item value with each category detail
            //     categoryDetails['value'] = categoryItem.value.text()
            //     categories << categoryDetails
            // }
            details['categories'] = categories
            subCategoryList << details
        }
    }
    return subCategoryList
}

// Fetch the subcategories and return the result
def result = fetchSubCategories()
return result