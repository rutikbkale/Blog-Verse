<nav class="navbar navbar-expand-lg navbar-dark bg-yo">
    <div class="container-fluid">
        <a class="navbar-brand fs-3 ms-3" href="dashboard"><img src="${pageContext.request.contextPath}/static/images/blogger.png" alt="alt" width="45px" height="40px"/> Blog Verse</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto  mb-lg-0">
                <li class="nav-item mx-4">
                    <a class="nav-link active text-white fs-5" aria-current="page" href="dashboard"><i class="fa-solid fa-house"></i> &nbsp;Home</a>
                </li>
                <li class="nav-item mx-4">
                    <a class="nav-link active text-white fs-5" aria-current="page" href="../category/getCategories"><i class="fa-solid fa-blog"></i></i> &nbsp;Add Post</a>
                </li>
                <li class="nav-item mx-4">
                    <a class="nav-link active text-white fs-5" aria-current="page" href="viewBlog"><i class="fa-solid fa-eye"></i></i> &nbsp;View Blogs</a>
                </li>
                <li class="nav-item mx-4">
                    <a class="nav-link active text-white fs-5" data-bs-toggle="modal" data-bs-target="#profileModal" href="#?"><i class="fas fa-user-circle"></i> Profile</a>
                </li>
                <li class="nav-item mx-4">
                    <a class="nav-link active text-white fs-5" href="#" onclick="signout()"><i class="fas fa-sign-out-alt"></i>&nbsp; Sign out</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="profileModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header bg-yo">
                <h1 class="modal-title fs-5 text-light text-center" id="exampleModalLabel"><i class="fas fa-user-circle fs-5"></i> User Profile</h1>
                <button type="button" class="btn-close bg-light" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <table class="table">
                    <tbody>
                        <tr>
                            <th>First Name : </th>
                            <td>${currentUser.firstName}</td>
                        </tr>
                        <tr>
                            <th>Last Name : </th>
                            <td>${currentUser.lastName}</td>
                        </tr>
                        <tr>
                            <th>Email : </th>
                            <td>${currentUser.email}</td>
                        </tr>
                        <tr>
                            <th>Date of Birth : </th>
                            <td>${currentUser.dob}</td>
                        </tr>
                        <tr>
                            <th>Mobile No : </th>
                            <td>${currentUser.mobNo}</td>
                        </tr>
                        <tr>
                            <th>Password : </th>
                            <td>${currentUser.password}</td>
                        </tr>
                    </tbody>
                </table>
                <div class="d-flex justify-content-evenly">
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#editModal"><i class="fas fa-solid fa-user-pen"></i> Edit</button>
                    <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal" data-bs-target="#passwordModal"><i class="fas fa-solid fa-key"></i> Change Password</button>
                    <button type="button" class="btn btn-warning" onclick="signout()"><i class="fas fa-sign-out-alt"></i> Sign out</button>
                </div>
            </div>
        </div>
    </div>
</div>

<!--editing user details-->
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header bg-yo">
                <h1 class="modal-title fs-5 text-light text-center" id="exampleModalLabel"><i class="fas fa-solid fa-user-pen fs-5"></i> Edit Details </h1>
                <button type="button" class="btn-close bg-light" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="editForm" method="post" id="editProfile">
                    <input type="hidden" name="userId" value="${currentUser.userId}">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th>First Name : </th>
                                <td>
                                    <input type="text" class="form-control" id="firstName" name="firstName" value="${currentUser.firstName}">
                                </td>
                            </tr>
                            <tr>
                                <th>Last Name : </th>
                                <td>
                                    <input type="text" class="form-control" id="lastName" name="lastName" value="${currentUser.lastName}">
                                </td>
                            </tr>
                            <tr>
                                <th>Email : </th>
                                <td>
                                    <input type="email" class="form-control" id="email" name="email" value="${currentUser.email}">
                                </td>
                            </tr>
                            <tr>
                                <th>Date of Birth : </th>
                                <td>
                                    <input type="date" class="form-control" id="dob" name="dob" value="${currentUser.dob}">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="text-center">
                        <input type="submit" class="btn btn-outline-warning" value="save" data-bs-toggle="modal" data-bs-target="#editModal">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!--changing password-->
<div class="modal fade" id="passwordModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header bg-yo">
                <h1 class="modal-title fs-5 text-light text-center" id="exampleModalLabel"><i class="fas fa-solid fa-key fs-5"></i> Change Password</h1>
                <button type="button" class="btn-close bg-light" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="changePassword" method="post" id="changePassword">
                    <input type="hidden" name="userId" value="${currentUser.userId}">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th>Old Password : </th>
                                <td>
                                    <input type="text" class="form-control" id="oldPassword" name="oldPassword" value="${currentUser.password}" disabled="disabled">
                                </td>
                            </tr>
                            <tr>
                                <th>New Password : </th>
                                <td>
                                    <input type="text" class="form-control" id="newPassword" name="password">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="text-center">
                        <input type="submit" class="btn btn-outline-warning" value="change" data-bs-toggle="modal" data-bs-target="#passwordModal">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>