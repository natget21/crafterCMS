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

            def details1 = siteItem;
            def categories = []
             siteItem.item?.descriptorDom?.component?.category_o?.item?.each { categoryItem ->
            def categoryPath = categoryItem.key?.text
            def categoryFile = siteItemService.getSiteItem(categoryPath)
            
                def categoryDetails = [
                    name: categoryFile.descriptorDom?.component?.categoryname_s,
                    description: categoryFile.descriptorDom?.component?.description
                ]
                categories << categoryFile
        }
        details['categories'] = categories
        subCategoryList << details1
        }
    }
    return subCategoryList