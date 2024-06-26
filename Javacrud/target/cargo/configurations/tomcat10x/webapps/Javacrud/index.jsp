<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    <script>
        function getAllUsers() {
            fetch('controller.do?action=getall')
                .then(response => response.json())
                .then(users => {
                    const tableBody = document.getElementById('userTableBody');
                    tableBody.innerHTML = ''; // Clear existing table rows
                    users.forEach(user => {
                        const row = document.createElement('tr');
                        row.innerHTML = `
                            <td>${user.user_id}</td>
                            <td>${user.user_name}</td>
                        `;
                        tableBody.appendChild(row);
                    });
                })
                .catch(error => console.error('Error fetching users:', error));
        }

        // Fetch all users when the page loads
        window.onload = getAllUsers;
    </script>
</head>
<body>
    <h1>User Management</h1>
    
    <h2>Insert User</h2>
    <form action="controller.do" method="POST">
        <input type="hidden" name="action" value="insert">
        <label for="user_name">User name:</label>
        <input type="text" id="user_name" name="user_name"><br>
        <label for="user_password">Password:</label>
        <input type="password" id="user_password" name="user_password"><br>
        <input type="submit" value="Insert User">
    </form>

    <h2>Delete User</h2>
    <form action="controller.do" method="POST">
        <input type="hidden" name="action" value="delete">
        <label for="user_id_name">User Name:</label>
        <input type="text" id="user_id_name" name="user_id_name"><br>
        <input type="submit" value="Delete User">
    </form>

    <h2>Update User</h2>
    <form action="controller.do" method="POST">
        <input type="hidden" name="action" value="update">
        <label for="user_id_update">User ID:</label>
        <input type="text" id="user_id_update" name="user_id_update"><br>
        <label for="user_name_update">New User Name:</label>
        <input type="text" id="user_name_update" name="user_name_update"><br>
        <label for="user_password_update">New Password:</label>
        <input type="password" id="user_password_update" name="user_password_update"><br>
        <input type="submit" value="Update User">
    </form>
<hr>
    <h2>All Users</h2>
    <table border="1">
        <thead>
            <tr>
                <th>User ID</th>
                <th>User Name</th>
            </tr>
        </thead>
        <tbody id="userTableBody">
           
        </tbody>
    </table>
</body>
</html>
