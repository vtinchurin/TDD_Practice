package ru.easycode.zerotoheroandroidtdd.main

import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface Navigation {

    interface Update:LiveDataWrapper.Update<Screen>

    interface Read:LiveDataWrapper.Read<Screen>

    interface Mutable:Update,Read

    class Base:Mutable,LiveDataWrapper.Abstract<Screen>()
}

