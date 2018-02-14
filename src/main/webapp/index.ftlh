<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Zed's CRUD Books</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-blue-grey w3-opacity">
    <h1>Zed's CRUD Books</h1>
</div>
<div class="w3-container w3-center">
    <table class="w3-table-all w3-striped">
        <tr class="w3-teal">
            <th>Id</th>
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
    </#list>
    </table>
    <a href="/addBook" class="w3-button w3-block w3-teal">Add</a>
    <div class="w3-center">
        <div class="w3-bar">
            <a href="#" class="w3-button">&laquo;</a>
            <a href="#" class="w3-button">1</a>
            <a href="#" class="w3-button">2</a>
            <a href="#" class="w3-button">3</a>
            <a href="#" class="w3-button">4</a>
            <a href="#" class="w3-button">&raquo;</a>
        </div>
    </div>
</div>
</body>
</html>