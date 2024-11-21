<#import "/templates/system/common/crafter.ftl" as crafter />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>MultiShop - Online Shop Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">
		<@crafter.head/>
	</head>
	<body>
		<@crafter.body_top/>
		<main>
			<@crafter.h1 $field="title_t">${model.title_t}</@crafter.h1>
			<@crafter.div $field="body_html">${model.body_html}</@crafter.div>
		</main>
		<@crafter.body_bottom/>
	</body>
</html>
