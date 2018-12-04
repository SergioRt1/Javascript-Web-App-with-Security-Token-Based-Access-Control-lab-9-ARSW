var Controller = (function () {

    function getAuthotization() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        getToken(username, password);
    }

    function getToken(username, password) {
        axios({
            method:'post',
            url:'/login',
            headers: {'Content-Type': 'application/json'},
            data:{
                "username": username,
                "password": password
            }
        })
            .then(function (response) {
                if(response.data==="") {
                    console.log(response);
                    localStorage['AUTH_TOKEN'] = response.headers.authorization;
                    axios.defaults.headers.common['Authorization'] = response.headers.authorization;
                    window.location.href = "/index.html";
                }else alert("Wrong credentials");
            })
            .catch(function (reason) {
                console.log(reason);
            })
    }

    function registerUser() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var confirm = document.getElementById("confirm").value;
        if (confirm === password) {
            register(username, password);
        } else alert("The password and confirmation are not equal");
    }

    function register(username, password) {
        axios.post('/users/sign-up', {
            "username": username,
            "password": password
        })
            .then(function (response) {
                console.log(response);
                window.location.href = "/login.html"
            })
            .catch(function (reason) {
                console.log(reason);
                alert(reason.response.data)
            })
    }

    function getTokenSaved() {
        return localStorage["AUTH_TOKEN"] || "";
    }

    function logout() {
        localStorage['AUTH_TOKEN'] = '';
        document.getElementById("logout").setAttribute("href","");
    }

    function isLogin() {
        if(localStorage['AUTH_TOKEN']==='')
            document.getElementById("logout").setAttribute("href","");
        else {
            document.getElementById("logout").removeAttribute("href");
            axios.defaults.headers.common['Authorization'] = localStorage['AUTH_TOKEN'];
        }
    }

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
                if(Array.isArray(response.data))
                    callback(response.data);
                else alert("Please Login");
            }).catch(function (error) {
            console.log(error);
            alert("Error happened");
        });
    }

    return {
        loadMessages: loadMessages,
        saveWord: saveWord,
        getAuthotization: getAuthotization,
        register: registerUser,
        logout:logout,
        isLogin:isLogin
    };
})();