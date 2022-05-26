package com.timmitof.moneytracker

import com.timmitof.moneytracker.models.Icons
import com.timmitof.moneytracker.models.OnBoardingItem

class Constants {
    companion object{
        val iconArray = arrayListOf(
            Icons(R.drawable.category_ic_airplane),
            Icons(R.drawable.category_ic_baby_bottle),
            Icons(R.drawable.category_ic_baby_diaper),
            Icons(R.drawable.category_ic_baby_toy),
            Icons(R.drawable.category_ic_badminton_sport),
            Icons(R.drawable.category_ic_baseball),
            Icons(R.drawable.category_ic_basketball),
            Icons(R.drawable.category_ic_beer),
            Icons(R.drawable.category_ic_bitcoin),
            Icons(R.drawable.category_ic_book),
            Icons(R.drawable.category_ic_bowling),
            Icons(R.drawable.category_ic_bus),
            Icons(R.drawable.category_ic_bycicle),
            Icons(R.drawable.category_ic_cake),
            Icons(R.drawable.category_ic_candies),
            Icons(R.drawable.category_ic_car),
            Icons(R.drawable.category_ic_card),
            Icons(R.drawable.category_ic_clothes),
            Icons(R.drawable.category_ic_cocktail_glass),
            Icons(R.drawable.category_ic_coins),
            Icons(R.drawable.category_ic_court),
            Icons(R.drawable.category_ic_cpu),
            Icons(R.drawable.category_ic_dinner),
            Icons(R.drawable.category_ic_dumbbels),
            Icons(R.drawable.category_ic_duty),
            Icons(R.drawable.category_ic_education_cap),
            Icons(R.drawable.category_ic_fastfood),
            Icons(R.drawable.category_ic_football),
            Icons(R.drawable.category_ic_fruits),
            Icons(R.drawable.category_ic_game_die),
            Icons(R.drawable.category_ic_gamepad),
            Icons(R.drawable.category_ic_garden_fence),
            Icons(R.drawable.category_ic_guitar),
            Icons(R.drawable.category_ic_gun),
            Icons(R.drawable.category_ic_hair_comb),
            Icons(R.drawable.category_ic_hand_money_cash),
            Icons(R.drawable.category_ic_hand_money_coins),
            Icons(R.drawable.category_ic_hockey),
            Icons(R.drawable.category_ic_home),
            Icons(R.drawable.category_ic_ice_hockey),
            Icons(R.drawable.category_ic_incognito),
            Icons(R.drawable.category_ic_instagram),
            Icons(R.drawable.category_ic_liquor),
            Icons(R.drawable.category_ic_mastercard),
            Icons(R.drawable.category_ic_medicine_bottle),
            Icons(R.drawable.category_ic_medicine_logo),
            Icons(R.drawable.category_ic_money_bag),
            Icons(R.drawable.category_ic_music),
            Icons(R.drawable.category_ic_notebook),
            Icons(R.drawable.category_ic_paint),
            Icons(R.drawable.category_ic_palm),
            Icons(R.drawable.category_ic_pets),
            Icons(R.drawable.category_ic_phone),
            Icons(R.drawable.category_ic_pizza),
            Icons(R.drawable.category_ic_repair),
            Icons(R.drawable.category_ic_save_money),
            Icons(R.drawable.category_ic_shop),
            Icons(R.drawable.category_ic_shopping_bag),
            Icons(R.drawable.category_ic_shopping_cart),
            Icons(R.drawable.category_ic_shovel),
            Icons(R.drawable.category_ic_skull),
            Icons(R.drawable.category_ic_snow),
            Icons(R.drawable.category_ic_snowboard),
            Icons(R.drawable.category_ic_sport_shoe),
            Icons(R.drawable.category_ic_sun_umbrella),
            Icons(R.drawable.category_ic_taxi),
            Icons(R.drawable.category_ic_teeth),
            Icons(R.drawable.category_ic_tennis),
            Icons(R.drawable.category_ic_toaster_breakfast),
            Icons(R.drawable.category_ic_train),
            Icons(R.drawable.category_ic_tv),
            Icons(R.drawable.category_ic_university),
            Icons(R.drawable.category_ic_volleyball),
            Icons(R.drawable.category_ic_wallet),
            Icons(R.drawable.category_ic_watch_oval),
            Icons(R.drawable.category_ic_watch_rectangle),
            Icons(R.drawable.category_ic_white_house),
            Icons(R.drawable.category_ic_work_bag)
        )

        val onBoardingList = listOf(
            OnBoardingItem(
                image = R.drawable.variant_gain_total_control_of_your_money,
                title = "Gain total control of your money",
                description = "Become your own money manager and make every cent count"
            ),
            OnBoardingItem(
                image = R.drawable.variant_know_where_your_money_goes,
                title = "Know where your money goes",
                description = "Track your transaction easily, with categories and financial report"
            ),
            OnBoardingItem(
                image = R.drawable.variant_planning_ahead,
                title = "Planning ahead",
                description = "Setup your budget for each category so you in control"
            )
        )
    }
}