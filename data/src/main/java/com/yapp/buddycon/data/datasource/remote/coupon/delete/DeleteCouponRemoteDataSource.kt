package com.yapp.buddycon.data.datasource.remote.coupon.delete

import com.yapp.buddycon.data.network.response.DeleteCouponResponse
import kotlinx.coroutines.flow.Flow

interface DeleteCouponRemoteDataSource {
    fun deleteCoupon(id: Int) : Flow<DeleteCouponResponse>
}