var Controller = (function () {

    function clearTables() {
        var content = document.getElementById("content");
        var tables = document.getElementsByClassName("table");
        while (tables.length > 0) {
            content.removeChild(tables[0]);
        }
        var titles = document.getElementsByClassName("table-title");
        while (titles.length > 0) {
            content.removeChild(titles[0]);
        }
    }

    function addTable(messages) {
        var tableMessage = document.createElement("table");
        var header = document.createElement("tr");

        var cell = document.createElement("th");
        cell.innerHTML = "Word";
        header.appendChild(cell);

        var cell = document.createElement("th");
        cell.innerHTML = "Date";
        header.appendChild(cell);

        tableMessage.appendChild(header);

        tableMessage.setAttribute("class", "table");
        tableMessage.setAttribute("id", "tableMessage");

        var title = document.createElement("h4");
        title.setAttribute("class", "table-title");
        title.innerHTML = "Data";
        var firstTable = document.getElementById("HTMLtable");
        content.insertBefore(tableMessage, firstTable);
        content.insertBefore(title, tableMessage);

        for (var i in messages) {
            addMessage(messages[i])
        }

    }

    function addMessage(message) {
        var row = document.createElement("tr");
        var cell = document.createElement("td");
        cell.innerHTML = message.message;

        row.appendChild(cell);

        var cell = document.createElement("td");
        cell.innerHTML = message.time;
        row.appendChild(cell);
        var tableMessage = document.getElementById("tableMessage");
        tableMessage.appendChild(row);
    }

    function saveWord() {
        var message = document.getElementById("word").value;
        var JSON = {
            "message": message,
        };
        axios.post("/message", JSON).then(function (response) {
            loadMessages();
        }).catch(function (error) {
            console.log(error);
            alert("Error happened");
        });

    }

    function loadMessages() {
        clearTables();
        loadData(addTable);
    }

    function loadData(callback) {
        axios.get("/message")
            .then(function (response) {
                callback(response.data);
            }).catch(function (error) {
            console.log(error);
            alert("Error happened");
        });
    }

    return {
        loadMessages: loadMessages,
        saveWord: saveWord
    };
})();