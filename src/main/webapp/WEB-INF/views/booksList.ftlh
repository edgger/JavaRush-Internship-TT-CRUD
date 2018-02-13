<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Author</th>
        <th>ISBN</th>
        <th>Print year</th>
        <th>Read already</th>
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
    </tr>
    </#list>
</table>
</body>
</html>