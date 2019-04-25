package com.example.scheduleapp.presentation

class ScreenItem {
    var tittle: String = ""
    var description: String = ""
    var ScreenImg: Int = 0

    constructor(tittle: String, description: String, ScreenImg: Int) {
        this.tittle = tittle
        this.description = description
        this.ScreenImg = ScreenImg
    }
}