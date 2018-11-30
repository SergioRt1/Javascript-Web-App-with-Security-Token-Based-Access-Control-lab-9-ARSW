var controller = (function () {

    var clearTables = function() {
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

    var publishMessage = function(){
        var message = docuement.getElementById()
    }

    var buildMessages = function(){
//        var tableOrder = document.createElement("table");
//                var header = document.createElement("tr");
//                var cell = document.createElement("th");
//                cell.innerHTML = "Product";
//                header.appendChild(cell);
    }

    var loadData = function(callback) {
        axios.get("http://localhost:8080/message").then(function (response) {
//                    callback(response.data);
                console.log(response);
              }).catch(function (error) {
                // handle error
                console.log(error);
              })
    }

    var loadMessages = function(){
        clearTables();
        loadData(buildMessages);
    }

    return {
        loadMessages:loadMessages,
        publishMessage:publishMessage
    };

})();