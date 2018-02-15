<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Zed's CRUD Books</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<#include "WEB-INF/views/templates/header.ftlh">
<div class="w3-container w3-center">
    <table class="w3-table-all w3-striped">
        <tr class="w3-teal">
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Author</th>
            <th>ISBN</th>
            <th>Print year</th>
            <th>Read already</th>
            <th>Action</th>
        </tr>
    <#list books as book>
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.description!}</td>
        <td>${book.author!}</td>
        <td>${book.isbn!}</td>
        <td>${book.printYear!}</td>
        <td>${book.readAlready?string('yes', 'no')!}</td>
        <td>
            <a href="/book/${book.id}" class="w3-button w3-small w3-teal w3-round">Edit</a>
            <a href="/delete/${book.id}" class="w3-button w3-small w3-teal w3-round">Delete</a>
            <a href="/read/${book.id}" class="w3-button w3-small w3-teal w3-round">Read</a>
        </td>
    </tr>
    <#else>
    <tr>
        <td>No available books</td>
    </tr>
    </#list>
    </table>
    <a href="/addBook" class="w3-button w3-block w3-teal">Add</a>
    <#if lastPageNumber??>
    <div class="w3-center">
        <div class="w3-bar">
            <a href="/" class="w3-button">First</a>
            <#list 0..lastPageNumber as x>
                <a href="/?page=${x}" class="w3-button">${x+1}</a>
            </#list>
            <a href="/?page=${lastPageNumber}" class="w3-button">Last</a>
        </div>
    </div>
    </#if>
</div>
</body>
</html>