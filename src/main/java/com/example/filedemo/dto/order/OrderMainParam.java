package com.example.filedemo.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
/** 
* @Description:   
* @Author: xukl
* @Date: 2021/9/17 13:46
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderMainParam {

    private static final long serialVersionUID = 1L;

    /**
     * URID
     */
    private String urid;

    /**
     * URID集合
     */
    private List<String> urids;

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
     * 插入时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 车付保平台_订单状态代码，太多，详情见映射关系
     *
     */
    private List<String> orderStateCodeList;

    /**
     * 首付款审核状态List
     *
     */
    private List<String> downPayReviewStateCodeList;

    /**
     * 平台服务费审核状态List
     *
     */
    private List<String> feeReviewStateCodeList;

    /**
     * 平台客户端分页列表查询：车牌号，全模糊查询
     */
    private String licenseNoLike;

    /**
     * 平台客户端分页列表查询：车架号，全模糊查询
     */
    private String frameNoLike;

    /**
     * 平台客户端分页列表查询：投保单号，全模糊查询
     */
    private String proposalNoLike;

    /**
     * 平台客户端分页列表查询：保单号，全模糊查询
     */
    private String policyNoLike;

    /**
     * 平台客户端分页列表查询：实授信流水号，全模糊查询
     */
    private String creditSerialNoLike;

    /**
     * 平台客户端分页列表查询：订单号，全模糊查询
     */
    private String orderNoLike;

    /**
     * 平台客户端分页列表查询：首付款流水号，全模糊查询
     */
    private String downPaySerialNoLike;

    /**
     * 平台客户端分页列表查询：支付保费流水号，全模糊查询
     */
    private String premiumPaySerialNoLike;

    /**
     * 当前用户及其所有下级的用户IdList
     */
    private List<String> selfAndAllSubGroupUserIdList;

    /**
     * 保单风险信号状态(风险信号推送银行接口)(01-全损、推定全损、灭失、被盗抢;02-其他保险公司中止保险合同情况;03-未生成保单)
     */
    private String policyRiskState;
    /**
     * 保单列表
     */
    private List<String> policyNoList;

    /**
     * 如果是1则筛选补差大于0的，null不校验
     */
    private String markMakeUpAmount;

    /**
     * 不需要包含的实授信流水号
     */
    private List<String> notCreditSerial;

    /**
     * 平台服务费到账确认 02-确认通过，03-确认通过失败
     */
    private String feeReviewState;

    /**
     * 交易明细ID，关联rbt_cfb_service_fee_detail表的ID
     */

    private String tradeId;

    private List<Integer> tradeIdList;

    /**
     * rbt_cfb_order_main的urid
     */
    private List<String> listUrid;

    /**
     * 首付款审核状态列表
     */
    private List<String> enOrderDownPayReviewStates;

    /**
     * 平台服务费审核状态列表
     */
    private List<String> enOrderPlatformFeeReviewStates;

    /**
     * 新增时间开始
     */
    private LocalDateTime newDateStart;

    /**
     * 新增时间结束
     */
    private LocalDateTime newDateEnd;

    /**
     * 企业模糊查询
     */
    private String enterpriseNameLike;

    /**
     * 企业模糊查询
     */
    private List<String> proposalStateCodeArray;

    /**
     * 是不是要查询fee_review_state_code字段是null的
     */
    private String isFeeReviewStateNull;
    /**
     * 是不是要查询down_pay_review_state_code字段是null的
     */
    private boolean isDownPayReviewStateNull;
    /**
     * 保单生效日起始时间
     */
    private LocalDateTime policyEffectiveTimeStart;

    /**
     * 保单生效日结束时间
     */
    private LocalDateTime policyEffectiveTimeEnd;


    /**
     * 首付支付截至日期起始时间
     */
    private LocalDateTime downPayExpiryTimeStart;

    /**
     * 首付支付截至日期结束时间
     */
    private LocalDateTime downPayExpiryTimeEnd;

    /**
     * 新投保单号
     */
    private String newProposalNo;

    /**
     * 投保人社会信用代码
     */
    private String applicantSocialCreditCode;

    /**
     * 投保人配置表urid列表
     */
    private List<String> applicantConfigIds;
}
