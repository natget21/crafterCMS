import groovy.xml.XmlSlurper
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

    // Fetch the subcategories folder item
    def siteTree = siteItemService.getSiteTree("/site/components/sub_categories", -1)
    def subCategoryList = []

    if (siteTree && siteTree.childItems) {
        siteTree.childItems.each { siteItem ->
            def details = [
                name: siteItem.item?.descriptorDom?.component?.subCategoryName_s,
                description: siteItem.item?.descriptorDom?.component?.description
            ]

            def categories = []
            siteItem.item?.descriptorDom?.component?.category_o?.item?.each { categoryItem ->
                def categoryPath = categoryItem.key.text()
                def categoryFile = contentLoader.loadContent(categoryPath)

                def xmlContent = new XmlSlurper().parseText(categoryFile.contentAsString)
                def categoryDetails = [
                        name       : xmlContent.categoryname_s.text(),
                        description: xmlContent.description.text()
                 ]
                // Include the item value with each category detail
                categoryDetails['value'] = categoryItem.value.text()
                categories << categoryDetails
            }
            details['categories'] = categories
            subCategoryList << details
        }
    }
    return subCategoryList