<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Zed's CRUD Books</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-teal">
    <h2><#if book??>Edit book<#else>Add book</#if></h2>
</div>

<form name="book" action=<#if book??>"/editBook"<#else>"/addBook"</#if> method="post" class="w3-container">
    <input type="hidden" name="id" <#if book??>value=${book.id}</#if>>

    <label class="w3-text-teal"><b>Title</b>
    <input class="w3-input w3-border w3-light-grey" name="title" type="text" <#if book??>value=${book.title}</#if>>
    </label>
    <label class="w3-text-teal"><b>Description</b>
    <input class="w3-input w3-border w3-light-grey" name="description" type="text" <#if book??>value=${book.description!}</#if>>
    </label>
<#if book??>
    <label class="w3-text-teal"><b>Author</b>
    <input class="w3-input w3-border w3-light-grey" name="author" type="text">
    </label>
</#if>
    <label class="w3-text-teal"><b>ISBN</b>
    <input class="w3-input w3-border w3-light-grey" name="isbn" type="text" <#if book??>value=${book.isbn!}</#if>>
    </label>
    <label class="w3-text-teal"><b>Print year</b>
    <input class="w3-input w3-border w3-light-grey" name="printYear" type="text" <#if book??>value=${book.printYear!}</#if>>
    </label>
    <br>
    <button type="submit" value="OK" class="w3-btn w3-blue-grey">Submit</button>
    <#--<a href="/" class="w3-btn w3-blue-grey"></a>-->
    <a href="/" class="w3-btn w3-blue-grey">Cancel</a>
</form>
</body>
</html>