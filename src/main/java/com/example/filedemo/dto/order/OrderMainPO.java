package com.example.filedemo.dto.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
* @Description:
* @Author: xukl
* @Date: 2021/9/17 11:50
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("rbt_cfb_order_main")
public class OrderMainPO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long pkId;

    /**
     * URID
     */
    @TableId(value = "urid", type = IdType.ASSIGN_UUID)
    private String urid;

    /**
     * 保融内部生成的订单号(雪花算法生成)
     */
    private String orderNo;

    /**
     * 二级平台登录用户ID(分期订单是在二级平台新增的)
     */
    private String userId;

    /**
     * 一级平台运营管理用户ID(审核订单、撤销投保单等)
     */
    private String operateUserId;

    /**
     * 一级平台财务管理用户ID(调账、支付保费等)
     */
    private String financeUserId;

    /**
     * 首付款流水信息表urid(可关联多个分期订单，不关联其他流水)
     */
    private String downPayId;

    /**
     * 支付保费流水信息表urid(可关联多个分期订单，不关联其他流水)
     */
    private String premiumPayId;

    /**
     * 实授信流水号，关联rbt_cfb_order_credit表(业务需求，分期订单列表要查这个字段，否则就不加了，下面的保司企业字段，也是出于这个考虑)
     */
    private String creditSerialNo;

    /**
     * 二级平台编号(一级平台推送已缴费投保单时必传)
     */
    private String secondPlatformCode;

    /**
     * 二级平台名称(一级平台推送已缴费投保单时必传)
     */
    private String secondPlatformName;

    /**
     * 企业信息主表urid
     */
    private String enterpriseMainId;

    /**
     * 企业名称
     */
    private String enterpriseName;

    /**
     * 企业统一社会信用代码
     */
    private String enterpriseSocialCreditCode;

    /**
     * 保司收款机构名称
     */
    private String payeeOrgName;

    /**
     * 套餐类型(套餐A是阶梯费率。先按初始费率计算，到达后再返还。保司业务来源支持A、B、C，外部业务来源支持C)
     */
    private String packageType;

    /**
     * 投保单号
     */
    private String proposalNo;

    /**
     * 是否新车(1-是; 0:否)
     */
    private String newCarFlag;

    /**
     * 车牌号(新车时,填写“新车未上牌”)
     */
    private String licenseNo;

    /**
     * 车架号
     */
    private String frameNo;

    /**
     * 发动机号
     */
    private String engineNo;

    /**
     * 保单号
     */
    private String policyNo;

    /**
     * 保单投保时间
     */
    private LocalDateTime policyInsuranceTime;

    /**
     * 保单生效时间
     */
    private LocalDateTime policyEffectiveTime;

    /**
     * 保单到期时间
     */
    private LocalDateTime policyExpiryTime;

    /**
     * 首付支付截至时间
     */
    private LocalDateTime downPayExpiryTime;

    /**
     * 商业险保费
     */
    private BigDecimal premiumBi;

    /**
     * 首付金额，商业险金额-最小整数（商业险金额*0.9）
     */
    private BigDecimal downPayAmount;

    /**
     * 分期金额，同应放款金额。预留字段，后续规则可能变更
     */
    private BigDecimal installmentAmount;

    /**
     * 预计放款金额(最小整数（商业险金额*0.9），实际放款金额可能会比这个小)
     */
    private BigDecimal expectMakeLoanAmount;

    /**
     * 中信银行返回的投保单状态(01-未登记;02-已登记;03-已失效;04-运行中;05-待退保;06-退保中;07-退保成功;08-退保失败;09-拒绝退保;10-已提前还款;11-已放款;12-生效日校验失败;13-待撤销;14-撤销成功;15-撤销失败;96-系统内部错误;97-无权限查询该投保单;98-已删除;99-查无此投保单)
     */
    private String proposalStateCiticBank;

    /**
     * 投保单审核状态(00-待审核;01-成功;02-失败)
     */
    private String proposalReviewState;

    /**
     * 投保单审核时间
     */
    private LocalDateTime proposalReviewTime;

    /**
     * 保单审核状态(00-待审核;01-成功;02-失败)
     */
    private String policyReviewState;

    /**
     * 保单审核时间
     */
    private LocalDateTime policyReviewTime;

    /**
     * 车付保平台_投保单状态代码，太多，详情见映射关系
     */
    private String proposalStateCode;

    /**
     * 投保单状态说明(通知或审核原因)
     */
    private String proposalStateDesc;

    /**
     * 投保单更新时间
     */
    private LocalDateTime proposalUpdateTime;

    /**
     * 车付保平台_订单状态代码，太多，详情见映射关系
     */
    private String orderStateCode;

    /**
     * 订单状态说明(通知或审核原因)
     */
    private String orderStateDesc;

    /**
     * 订单更新时间
     */
    private LocalDateTime orderUpdateTime;

    /**
     * 有效状态(1-有效; 0-无效)
     */
    private String validStatus;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 更新者
     */
    private String updator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
