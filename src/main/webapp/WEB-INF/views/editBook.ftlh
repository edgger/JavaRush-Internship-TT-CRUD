<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Zed's CRUD Books</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<#include "templates/header.ftlh">
<div class="w3-container w3-teal">
    <h2><#if book??>Edit book<#else>Add book</#if></h2>
</div>
<form name="bookData" action=<#if book??>"/editBook"<#else>"/addBook"</#if> method="post" class="w3-container">
    <#if book??><input type="hidden" name="id" required value="${book.id}"></#if>

    <label class="w3-text-teal"><b>Title</b>
    <input class="w3-input w3-border w3-light-grey" name="title" type="text" pattern="^[a-zA-Z0-9\s]{1,100}$" required <#if book??>value="${book.title}"</#if>>
    </label>
    <label class="w3-text-teal"><b>Description</b>
    <input class="w3-input w3-border w3-light-grey" name="description" type="text" pattern="^[A-Za-z0-9\s]{0,255}$" <#if book??>value="${book.description!''}"</#if>>
    </label>
    <label class="w3-text-teal"><b>Author</b>
    <input class="w3-input w3-border w3-light-grey" name="author" type="text" pattern="^[A-Za-z\s]{1,100}$" required <#if book??>value="${book.author!''}" readonly</#if>>
    </label>
    <label class="w3-text-teal"><b>ISBN</b>
    <input class="w3-input w3-border w3-light-grey" name="isbn" type="text" placeholder="0-000000-00-0"
           pattern="^(?:(?=.{17}$)97[89][ -](?:[0-9]+[ -]){2}[0-9]+[ -][0-9]|97[89][0-9]{10}|(?=.{13}$)(?:[0-9]+[ -]){2}[0-9]+[ -][0-9Xx]|[0-9]{9}[0-9Xx])$"
           <#if book??>value=${book.isbn!''}</#if>>
    </label>
    <label class="w3-text-teal"><b>Print year</b>
    <input class="w3-input w3-border w3-light-grey" name="printYear" type="text" pattern="\d{4}" required placeholder="0000" <#if book??>value="${book.printYear?string.computer!''}"</#if>>
    </label>
    <br>
    <button type="submit" value="OK" class="w3-btn w3-blue-grey">Submit</button>
    <a href="/" class="w3-btn w3-blue-grey">Cancel</a>
</form>
</body>
</html>