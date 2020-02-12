package com.sample.data.remote

class UserDataSource(private val userService: UserService) {

    fun getUser() = userService.getUser()
}