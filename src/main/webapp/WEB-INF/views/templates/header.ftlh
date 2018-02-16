<div class="w3-container w3-blue-grey w3-opacity">
    <a href="/"><h1>Zed's CRUD Books</h1></a>
    <form class="w3-row w3-card-4" name="searchData" action="/searchBook" method="post">
        <div class="w3-quarter">
            <select class="w3-select w3-container" name="field">
                <option value="" disabled selected>Choose field for search</option>
                <option value="id">ID</option>
                <option value="title">Title</option>
                <option value="author">Author</option>
            </select>
            <input class="w3-input w3-light-grey w3-container" name="value" type="text" pattern="[A-Za-zА-Яа-яЁё0-9]{,100}">
        </div>
        <button type="submit" value="OK" class="w3-btn w3-teal w3-large">Search</button>
    </form>
</div>