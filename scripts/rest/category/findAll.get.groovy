def searchResponse = searchClient.search(r -> r
    .query(q -> q
        .bool(b -> b
            .must(m -> m
                .term(t -> t
                    .field("content-type")
                    .value("/component/categories")
                )
            )
            .must(m -> m
                .wildcard(w -> w
                    .field("localId")
                    .value("/site/components/categories/*") // Filters by path
                )
            )
            .mustNot(m -> m
                .exists(e -> e
                    .field("_deleted") // Excludes deleted records
                )
            )
        )
    )
, Map)

def itemsFound = searchResponse.hits().total().value()
def items = searchResponse.hits().hits()*.source()

return [
    status: 200,
    itemsFound: itemsFound,
    macroCategories: items
]