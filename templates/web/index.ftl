<#-- index.ftl -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>${document.title}</title>
    <#include "/components/head.ftl">
</head>
<body>

    <#-- Preloader -->
    <#include "/components/preloader.ftl">

    <#-- Header -->
    <#include "/components/header.ftl">

    <#-- Main Banner -->
    <#include "/components/banner.ftl">

    <#-- Sections (Men, Women, Kids) -->
    <#include "/components/men.ftl">
    <#include "/components/women.ftl">
    <#include "/components/kids.ftl">

    <#-- Explore Section -->
    <#include "/components/explore.ftl">

    <#-- Social Media -->
    <#include "/components/social.ftl">

    <#-- Subscribe Section -->
    <#include "/components/subscribe.ftl">

    <#-- Footer -->
    <#include "/components/footer.ftl">

</body>
</html>
