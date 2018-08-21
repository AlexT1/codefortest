package com.alexstudy.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author AlexTong
 * @ClassName AmtHelper
 * @Description TODO()
 * @date 2018/6/21 16:30:25
 */
public class AmtHelper {
    private static final Logger logger = LoggerFactory.getLogger(AmtHelper.class);

    public  static Map<String,Integer> feeCodeRank = new HashMap<String,Integer>();

    private static Map<SourceType , FeeType>  specifyRepayRelation = new HashMap<SourceType , FeeType>();

    static {
        feeCodeRank.put("8001", 1);
        feeCodeRank.put("5003", 2);
        feeCodeRank.put("5002", 3);
        feeCodeRank.put("5001", 4);
        feeCodeRank.put("1002", 5); //		INTEREST("1002", "利息"),
        feeCodeRank.put("1001", 6);



        specifyRepayRelation.put(SourceType.FEE_BREAKS_OVERDUE, FeeType.OVERDUE_SERVICE_FEE);
        specifyRepayRelation.put(SourceType.FEE_BREAKS_PENALTY, FeeType.OVERDUE_PENALTY);


//		BREAKS_SERVICE_FEE_SUM("7002", "累计已减免逾期手续费"),
//		BREAKS_PENALTY_AMT_SUM("7003", "累计已减免逾期违约金");

//		CAPITAL("1001", "本金"),
//		SERVICE_FEE("5001", "分期手续费"),
//		OVERDUE_SERVICE_FEE("5002", "逾期手续费"),
//		OVERDUE_PENALTY("5003", "逾期违约金"),
    }


    public static  void sortList(List<GoalAmtData> goalAmts){
        Collections.sort(goalAmts,new Comparator<GoalAmtData>() {

            @Override
            public int compare(GoalAmtData o1, GoalAmtData o2) {
                int period1 = o1.getPeriod();
                int period2 = o2.getPeriod();
                int rank1 =  feeCodeRank.get(o1.getFeeCode()) == null?1000:feeCodeRank.get(o1.getFeeCode())  ;
                int rank2 = feeCodeRank.get(o2.getFeeCode()) == null?1000:feeCodeRank.get(o2.getFeeCode())  ;;
                return (period1*100 +rank1) - (period2*100 + rank2) ;
            }
        });
    }


    public static void repayAllGoal(List<RepayAmtData> repayAmts, List<GoalAmtData> goalAmts) {

        logger.info("拆分前数据："+repayAmts+goalAmts);
        List<RepayAmtData> specifyRepayAmtData  = specifyDirectionRepay(repayAmts, goalAmts);
        List<RepayAmtData> rankRepayAmtData = rankRepayGoal(repayAmts, goalAmts);


        List<RepayAmtData> newRepayAmts  =  new ArrayList<RepayAmtData>();

        newRepayAmts.addAll(specifyRepayAmtData);
        newRepayAmts.addAll(rankRepayAmtData);

        repayAmts.clear();
        repayAmts.addAll(newRepayAmts);

        logger.info("拆分后数据："+repayAmts+goalAmts);

    }

    public static void main(String[] args) {
        String params = "{\n" +
                "\t\"method\":\"wholeCompensation\",\n" +
                "\t\"sign\":\"e848b1fefab4d80183fff91704823a69\",\n" +
                "\t\"params\": {\n" +
                "\t\t\"orderNo\":\"PL2017050413344397294085\",\n" +
                "\t\t\"uniqueNo\":\"201806060005\",\n" +
                "\t\t\"date\":20180625,\n" +
                "\t\t\"amount\":\"17620.24\",\n" +
                "\t\t\"details\":[{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"2\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"3\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"4\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"5\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"6\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"7\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"8\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"9\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"10\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"11\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"amount\":\"1601.84\",\n" +
                "\t\t\t\"refundCapital\":\"1171.18\",\n" +
                "\t\t\t\"refundInterest\":\"0\",\n" +
                "\t\t\t\"refundCommission\":\"285.04\",\n" +
                "\t\t\t\"periodNumber\":\"12\",\n" +
                "\t\t\t\"refundOverdue\": \"145.62\"\n" +
                "\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "}";
        Map<String, Object>  map = (Map<String, Object>) JSONObject.fromObject(params);


        Map<String, String> paramsMap2 = (Map<String, String>) map.get("params");

        System.out.println(paramsMap2.get("orderNo").toString());
        System.out.println(paramsMap2.get("details") != null);
        JSONArray jsonArray = JSONArray.fromObject(paramsMap2.get("details"));
        System.out.println(jsonArray.size());
        List<DetailData> detailDataList = JSONArray.toList(jsonArray, new DetailData(), new JsonConfig());
        System.out.println(detailDataList.size());
//        String contractNo="C2017091816120218480697";
//        List<RepayAmtData> repayAmts = new ArrayList<RepayAmtData>();
//        List<GoalAmtData> goalAmts = new ArrayList<GoalAmtData>();
//
//        repayAmts.add(new RepayAmtData("20180621153523973_CR18062103285475", SourceType.EXCESSIVE, new Date(), contractNo, BigDecimal.valueOf(2000.00), 1));
//        //	repayAmts.add(new RepayAmtData("ZW20180613103658936707309",SourceType.NORMAL_DEDUCT,new Date(),"C2017101215071345614566", BigDecimal.valueOf(5287.11),1));
//     BillFeeDtl billFeeDtl = new BillFeeDtl();
//        billFeeDtl.setCurrReceiveAmt(BigDecimal.valueOf(3232.48));
//        billFeeDtl.setBillCode("BLC20170918161202184806978");
//        billFeeDtl.setFeeCode("1001");
//        billFeeDtl.setFeeName("本金");
//        billFeeDtl.setCurrPeriod(8);
//        billFeeDtl.setCurrReceiptAmt(BigDecimal.valueOf(539.37));
//        billFeeDtl.setId(1564118);
//        billFeeDtl.setVersion(0);
//        billFeeDtl.setContractNo(contractNo);
//        goalAmts.add(new GoalAmtData(billFeeDtl));
//        billFeeDtl.setCurrReceiveAmt(BigDecimal.valueOf(59.85));
//        billFeeDtl.setBillCode("BLC20170918161202184806978");
//        billFeeDtl.setFeeCode("5002");
//        billFeeDtl.setFeeName("逾期服务费");
//        billFeeDtl.setCurrPeriod(8);
//        billFeeDtl.setCurrReceiptAmt(BigDecimal.ZERO);
//        billFeeDtl.setId(3654162);
//        billFeeDtl.setVersion(0);
//        billFeeDtl.setContractNo(contractNo);
//        goalAmts.add(new GoalAmtData(billFeeDtl));
//
//        repayAllGoal(repayAmts, goalAmts);
        //	repayAllGoal(repayAmts, new ArrayList<GoalAmtData>());
    }


    private static List<RepayAmtData> rankRepayGoal(List<RepayAmtData> repayAmts, List<GoalAmtData> goalAmts) {
        sortList(goalAmts);

        repayGoal(repayAmts, goalAmts);
        logger.info("rankRepayAmts:"+repayAmts);
        return repayAmts;
    }

    /**
     * 指定方向还款
     * @param repayAmts
     * @param goalAmts
     */
    private static List<RepayAmtData> specifyDirectionRepay(List<RepayAmtData> repayAmts, List<GoalAmtData> goalAmts) {
        List<RepayAmtData> specifyDirectionRepayAmtData = new ArrayList<RepayAmtData>();
        for( SourceType sourceType  : specifyRepayRelation.keySet() ){
            FeeType feeType = specifyRepayRelation.get(sourceType);
            List<RepayAmtData> repayAmtDatas =  abstractRepayAmt(repayAmts, sourceType);
            List<GoalAmtData> goalAmtDatas =  abstractGoalAmt(goalAmts, feeType);
            logger.info("指向性还款数据："+repayAmtDatas+goalAmtDatas);
            repayGoal(repayAmtDatas,goalAmtDatas);
            specifyDirectionRepayAmtData.addAll(repayAmtDatas);
        }
        return specifyDirectionRepayAmtData;
    }


    private static  void repayGoal(List<RepayAmtData> repayAmts, List<GoalAmtData> goalAmts) {
        for(GoalAmtData goalAmt : goalAmts){
            repaySingleGoal(repayAmts, goalAmt);
        }

    }


    private static List<GoalAmtData> abstractGoalAmt(List<GoalAmtData> goalAmts, FeeType feeType) {
        List<GoalAmtData> goalAmtDatas = new ArrayList<GoalAmtData>();

        for(GoalAmtData goalAmt : goalAmts){
            if(goalAmt.getFeeCode().equals(feeType.getValue())){
                goalAmtDatas.add(goalAmt);
            }
        }
        return goalAmtDatas;
    }


    private static List<RepayAmtData> abstractRepayAmt(List<RepayAmtData> repayAmts, SourceType sourceType) {
        List<RepayAmtData>  repayAmtDatas = new ArrayList<RepayAmtData>();
        for (Iterator<RepayAmtData> it = repayAmts.iterator(); it.hasNext();) {
            RepayAmtData repayAmtData = it.next();
            if(repayAmtData.getSourceType()==sourceType){
                repayAmtDatas.add(repayAmtData);
                it.remove();
            }
        }
        return repayAmtDatas;
    }


    public static void repayAllGoal(RepayAmtData repayAmt, List<GoalAmtData> goalAmts) {

        List<RepayAmtData> repayAmts = new ArrayList<RepayAmtData>();
        repayAmts.add(repayAmt);
        repayAllGoal(repayAmts, goalAmts);

    }


    private static void repaySingleGoal(List<RepayAmtData> repayAmts, GoalAmtData goalAmt) {

        for (RepayAmtData repayAmt : repayAmts) {
            if (repayAmt.isFinish() || goalAmt.isFinish()) {
                continue;
            }
            BigDecimal usedAmount = goalAmt.addAmount(repayAmt.getNoUsedAmount(), repayAmt.getSourceNo(),repayAmt.getSourceType());
            repayAmt.subAmount(usedAmount);
        }
    }


//    public static Collection<BillMainData> calcGoalAmtData(List<GoalAmtData> billAmtList) {
//        Map<String,BillMainData> billMainRepayTotal = new TreeMap<String,BillMainData>(); //用 TreeMap 保证有序！
//        for(GoalAmtData billAmt  : billAmtList){
//            if(!billAmt.isRepay()){
//                continue;
//            }
//            addOrUpdateBillMainData(billMainRepayTotal,billAmt );
//        }
//        return  billMainRepayTotal.values();
//    }
//
//
//    private static void addOrUpdateBillMainData(Map<String, BillMainData> billMainRepayTotal, GoalAmtData billAmt) {
//        String billCode = billAmt.getBillCode();
//        BigDecimal  finishAmount = billAmt.getAllFinishAmount().subtract(billAmt.getOrignFinishAmount());
//        BillMainData billMainData   = billMainRepayTotal.get(billCode);
//
//        if(billMainData ==null){
//            billMainRepayTotal.put(billCode, new BillMainData(billCode,finishAmount));
//        }else{
//            billMainData.addRepayAmount(finishAmount);
//        }
//
//    }
//
//
//    public static Map<String, List<RepayAmtData>> buildRapayAmtMapGroupByContractNo(List<TransJournalDTL> transJournals,
//                                                                                    List<FeeBreaksApplyDtl>   feeBreaksApplyDtls ) {
//        Map<String, List<RepayAmtData>> repayAmtMap = new TreeMap<String, List<RepayAmtData>>();
//        for (TransJournalDTL transJournalDTL : transJournals) {
//            String contractNo = transJournalDTL.getContractNo();
//            List<RepayAmtData> repayAmtList = repayAmtMap.containsKey(contractNo) ? repayAmtMap.get(contractNo)
//                    : new ArrayList<RepayAmtData>();
//            repayAmtList.add(new RepayAmtData(  transJournalDTL));
//            repayAmtMap.put(contractNo, repayAmtList);
//        }
//
//        for (FeeBreaksApplyDtl feeBreaksApplyDtl : feeBreaksApplyDtls) {
//            String contractNo = feeBreaksApplyDtl.getContractNo();
//            List<RepayAmtData> repayAmtList = repayAmtMap.containsKey(contractNo) ? repayAmtMap.get(contractNo)
//                    : new ArrayList<RepayAmtData>();
//            repayAmtList.add(new RepayAmtData(  feeBreaksApplyDtl));
//            repayAmtMap.put(contractNo, repayAmtList);
//        }
//        logger.info("buildRapayAmtMapGroupByContractNo:"+repayAmtMap);
//        return repayAmtMap;
//    }
//
//    public static List<RepayAmtData> buildRapayAmt(List<FeeBreaksApplyDtl> feeBreaksApplyDtls) {
//        List<RepayAmtData> repayAmtList =new ArrayList<RepayAmtData>();
//        for (FeeBreaksApplyDtl feeBreaksApplyDtl : feeBreaksApplyDtls) {
//            repayAmtList.add(new RepayAmtData(  feeBreaksApplyDtl));
//        }
//        return repayAmtList;
//    }
//
//
//    public static RepayAmtData buildRapayAmt(TransJournalDTL transJournalDTL) {
//        return new RepayAmtData(  transJournalDTL);
//    }
//
//
//    public static RepayAmtData buildRapayAmt(CompanyAccountPayRegister companyRepay) {
//        return new RepayAmtData(  companyRepay);
//    }
//
//
//    public static Map<String, List<String>> buildBillMainNoMapGroupByContractNo(List<TransJournalDTL> transJournals,String contranct) {
//        Map<String, List<String>> contractBillNoMap = new TreeMap<String, List<String>>();
//        if(transJournals.isEmpty()){
//            contractBillNoMap.put(contranct,  new ArrayList<String>());
//            return contractBillNoMap;
//        }
//
//        for (TransJournalDTL transJournalDTL : transJournals) {
//            String contractNo = transJournalDTL.getContractNo();
//            List<String> billNos = contractBillNoMap.containsKey(contractNo) ?
//                    contractBillNoMap.get(contractNo) : new ArrayList<String>();
//            List<String>  tempBillNos =	SourceCodeData.paser(transJournalDTL.getSourceCode()).getBillCode() ;
//            billNos.addAll(tempBillNos);
//            contractBillNoMap.put(contractNo, billNos);
//        }
//        return contractBillNoMap;
//    }

}
