<#import "/templates/system/common/crafter.ftl" as crafter />

<#-- index.ftl -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>${document.title}</title>
    <#include "/templates/web/fragments/head.ftl">
</head>
<body>

    <#-- Preloader -->
    <#include "/templates/web/fragments/preloader.ftl">

    <#-- Header -->
    <#include "/templates/web/fragments/header.ftl">

    <#-- Main Banner -->
    <#include "/templates/web/components/banner.ftl">

    <#-- Sections (Men, Women, Kids) -->
    <#include "/templates/web/components/men.ftl">
    <#include "/templates/web/components/women.ftl">
    <#include "/templates/web/components/kids.ftl">

    <#-- Explore Section -->
    <#include "/templates/web/components/explore.ftl">

    <#-- Social Media -->
    <#include "/templates/web/components/social.ftl">

    <#-- Subscribe Section -->
    <#include "/templates/web/components/subscribe.ftl">

    <#-- Footer -->
    <#include "/templates/web/fragments/footer.ftl">
    
    <!-- Scripts -->
    <#include "/templates/web/fragments/scripts.ftl">

</body>
</html>
