// def subCategoriesItem = siteItemService.getSiteItem("/site/components/sub_categories");
// return subCategoriesItem;

def siteTree = siteItemService.getSiteTree("/site/components/sub_categories", -1)
def subCategoryList = []
if (siteTree) {
    def items = siteTree.childItems;
    items.each { siteItem ->
        subCategoryList.add(siteItem);
    }
    return subCategoryList;
}