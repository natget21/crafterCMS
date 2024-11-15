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
                def categoryPath = categoryItem.key
                def categoryFile = siteItemService.getSiteItem("/site/components/categories/b433e04d-b38c-8349-62a6-5e4c3665a612.xml", -1)
                categoryFile.childItems.each { category ->
                 def categoryDetails = [
                        name : siteItem.item?.descriptorDom?.component?.categoryname_s,
                        description: siteItem.item?.descriptorDom?.component?.description
                 ]
                    
                }

                categories << categoryDetails
            }
            details['categories'] = categories
            subCategoryList << details
        }
    }
    return subCategoryList