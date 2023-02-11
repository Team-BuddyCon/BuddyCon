package com.yapp.buddycon.presentation.ui.giftcon

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yapp.buddycon.domain.model.CouponInfo
import com.yapp.buddycon.presentation.R
import com.yapp.buddycon.presentation.databinding.ItemCouponBinding
import java.time.LocalDate
import java.time.Period

class GiftconAdapter :
    PagingDataAdapter<CouponInfo, GiftconAdapter.GiftconViewHoler>(GIFTCON_DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: GiftconViewHoler, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiftconViewHoler {
        return GiftconViewHoler(
            ItemCouponBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    class GiftconViewHoler(
        private val binding: ItemCouponBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(info: CouponInfo) {
            binding.itemCouponTvTitle.text = info.name
            binding.itemTvExpirationPeriod.text = "~${info.expireDate.replace("-", ".")}"
            if (info.usable) {
                val (year, month, day) = info.expireDate.split("-").map { it.toInt() }
                binding.btnExpireDate.isVisible = true
                binding.btnExpireDate.text =
                    "D${Period.between(LocalDate.now(), LocalDate.of(year, month, day)).days}"
            } else {
                binding.btnExpireDate.isVisible = false
            }

            Glide.with(binding.ivCoupon.context)
                .load(info.imageUrl)
                .placeholder(R.drawable.img_theme1)
                .into(binding.ivCoupon)
        }
    }


    companion object {
        private val GIFTCON_DIFF_CALLBACK = object : DiffUtil.ItemCallback<CouponInfo>() {
            override fun areItemsTheSame(oldItem: CouponInfo, newItem: CouponInfo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CouponInfo, newItem: CouponInfo): Boolean {
                return oldItem == newItem
            }
        }
    }
}