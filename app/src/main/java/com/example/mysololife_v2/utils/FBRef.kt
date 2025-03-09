package com.example.mysololife_v2.utils

import com.google.firebase.Firebase
import com.google.firebase.database.database

class FBRef {

    companion object {
        private val database = Firebase.database

        val bookmarkRef = database.getReference("bookmark_list")
    }
}