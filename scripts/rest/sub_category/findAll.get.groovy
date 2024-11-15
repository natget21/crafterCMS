def searchResponse = searchClient.search(r -> r
    .query(q -> q
        .bool(b -> b
            .should(s -> s
                .match(m -> m
                  .field('content-type')
                  .query(v -> v
                    .stringValue('/component/subcategory')
                  )
                )
              )
            .must(m -> m
                .wildcard(w -> w
                    .field("localId")
                    .value("/site/components/sub_categories/*")
                )
            )
        )
    )
, Map)

def itemsFound = searchResponse.hits().total().value()
def items = searchResponse.hits().hits()*.source()

return [
    status: 200,
    itemsFound:itemsFound,
    subcategories: items
]