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
                name: child.name,
                description: child.descriptorDom?.component?.description
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
            subCategoryList << siteItem
        }
    }
    return subCategoryList