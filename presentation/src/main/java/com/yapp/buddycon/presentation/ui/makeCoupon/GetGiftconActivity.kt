package com.yapp.buddycon.presentation.ui.makeCoupon

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.yapp.buddycon.presentation.R
import com.yapp.buddycon.presentation.base.BaseActivity
import com.yapp.buddycon.presentation.databinding.ActivityGetGiftconBinding
import com.yapp.buddycon.presentation.ui.giftcon.GetGiftConAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GetGiftConActivity : BaseActivity<ActivityGetGiftconBinding>(R.layout.activity_get_giftcon) {

    private val getGiftConVieModel: GetGiftConViewModel by viewModels()
    private val giftConAdapter = GetGiftConAdapter{getGiftConVieModel.changeItem(it)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.rvGiftcon.adapter = giftConAdapter
        binding.viewModel = getGiftConVieModel
        initGiftConData()
    }

    private fun initGiftConData() {
        lifecycleScope.launch {
            getGiftConVieModel.couponPagingData.collectLatest {
                giftConAdapter.submitData(it)
                binding.rvGiftcon.scrollToPosition(0)
            }
        }
    }
}