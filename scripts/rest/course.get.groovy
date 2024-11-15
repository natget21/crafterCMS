import groovy.xml.XmlSlurper

def siteTree = siteItemService.getSiteTree("/site/components/items/course", -1)
def courseList = []

    if (siteTree && siteTree.childItems) {
        siteTree.childItems.each { course ->
            def details = [
                nome_s: course.item?.descriptorDom?.component?.nome_s,
                partner_s:course.item?.descriptorDom?.component?.partner_s,
                costo_s: course.item?.descriptorDom?.component?.costo_s,
                durata_s: course.item?.descriptorDom?.component?.durata_s,
                modalita_s: course.item?.descriptorDom?.component?.modalita_s,
                obiettivo_s: course.item?.descriptorDom?.component?.obiettivo_s,
                contenuto_s:course.item?.descriptorDom?.component?.contenuto_s,
                rivolto_s: course.item?.descriptorDom?.component?.rivolto_s,
                maxpartecipanti_s:course.item?.descriptorDom?.component?.maxpartecipanti_s,
            ]

            def subCategories = []
            course.item?.descriptorDom?.component?.subcategory_o?.item?.each { subCategoryItem ->
            def subCategoryPath = subCategoryItem.key?.text
            // def subCategoryFile = siteItemService.getSiteItem(categoryPath)
            // def subCategoryDetails = [
            //         name: subCategoryFile.item?.descriptorDom?.component?.subCategoryName_s,
            //         description: subCategoryFile.item?.descriptorDom?.component?.description
            // ]

                subCategories << subCategoryPath
        }
        details['subCategories'] = subCategories
        courseList << details
        }
    }
    return courseList