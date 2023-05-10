package com.zxcv5595.domain.domain

import com.zxcv5595.api.loan.encrypt.Encrypt
import javax.persistence.*

@Entity
@Table(name = "USER_INFO")
class UserInfo(
        @Column(name = "usr_key")
        val userKey: String,

        @Encrypt
        @Column(name = "usr_reg_num")
        val userRegistrationNumber: String,

        @Column(name = "usr_nm")
        val userName: String,

        @Column(name = "usr_icm_amt")
        val userIncomeAmount: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

}