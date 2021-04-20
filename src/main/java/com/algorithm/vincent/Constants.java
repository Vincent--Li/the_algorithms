package com.algorithm.vincent;

public class Constants {
    public static String dbType;
    public static final String CACHE_SPLIT = "θ";
    public static final String MINUS = "MINUS";
    public static final String INTERFACE_IMPORT = "INTERFACE_IMPORT";
    public static final String SOURCE_SYSTEM_HSCS = "HSCS";

    public Constants() {
    }


    public static class Profile {
        public static final String MULTI_EXPIRE = "HSPM.MULTI_REDIS_EXPIRE";
        public static final String IMMEDIATELY_FEEDBACK = "HSAE.IM_ROLLBACK_ENABLE_FLAG";
        public static final String ROLLBACK_ACCOUNTS_BACKUP = "HSAE.IS_ROLLBACK_BACKUP_FLAG";
        public static final String CREATE_ACCOUNT_MAX_LIMIT = "HSAE.CREATE_ACCOUNT_MAX_LIMIT";
        public static final String CREATE_REVERSE_ACCOUNT_MAX_LIMIT = "HSAE.REV_ACCOUNT_MAX_LIMIT";

        public Profile() {
        }
    }

    public static class Cache {
        public static final String COLON = ":";
        public static final String LOV_SQL_VALUE = "hscs:hsae:lov:sql:value:";

        public Cache() {
        }
    }

    public static class Lov {
        public static final String HSPM_VALUE_SET_COLLECT = "HSPM_VALUE_SET_COLLECT";
        public static final String HSPM_CODE_RULE_COLLECT = "HSPM_CODE_RULE_COLLECT";
        public static final String HSAE_ACCOUNT_NAME = "HSAE_ACCOUNT_NAME";
        public static final String HPFM_LOV_VIEW = "HPFM_LOV_VIEW";

        public static final String HSPM_COMPANY = "HSPM_COMPANY";
        public static final String HSPM_SOA_DEPT = "HSPM_SOA_DEPT";
        public static final String HSPM_SOA_BU = "HSPM_SOA_BU";

        public Lov() {
        }
    }

    public static class Code {
        public static final String HSAE_TFREVENT_ACCOUNT_STATUS = "HSAE.ACCOUNT_STATUS";
        public static final String HSAE_FEEDBACK_DELIVERY_STATUS = "HSAE.ACCT_TRF.DELIVERY_STATUS";
        public static final String HSPM_YES_NO = "HSPM.YES_NO";
        public static final String HSPM_SOURCE_SYS = "HSPM.SOURCE_SYS";
        public static final String HSAE_ACCOUNT_VALUE_TYPE = "HSAE.ACCOUNT.VALUE_TYPE";
        public static final String HSAE_ACCOUNT_ACCOUNT_LEVER = "HSAE.ACCOUNT.ACCOUNT_LEVER";
        public static final String HSAE_ACCOUNT_SUMMARY_METHOD = "HSAE.ACCOUNT.SUMMARY_METHOD";
        public static final String HSAE_ACCOUNT_SUMMARY_TYPE = "HSAE.ACCOUNT.SUMMARY_TYPE";
        public static final String HSAE_MAPPING_COLUMN_TYPE = "HSAE.MAPPING.COLUMN_TYPE";
        public static final String HSAE_RULE_VALUE_MODE = "HSAE.RULE.VALUE_MODE";
        public static final String HSAE_RULE_NUMBER_SIGN = "HSAE.RULE.NUMBER_SIGN";
        public static final String HSAE_RULE_DATE_FORMAT = "HSAE.RULE.DATE_FORMAT";
        public static final String HSAE_BATCH_ACC_TABLE = "HSAE.BATCH.ACC_TABLE";
        public static final String HSAE_EVENT_COMMON_VALUE = "HSAE.EVENT.COMMON_VALUE";
        public static final String HSAE_FEEDBACK_RPOCESS_FLAG = "HSAE.FEEDBACK.RPOCESS_FLAG";
        public static final String HSAE_IMPORT_DATA_IMPORT_METHOD = "HSAE.IMPOPT.SOURCE_METHOD";
        public static final String HSAE_ACCT_TRF_VALUE_TYPE = "HSAE.ACCT_TRF.VALUE_TYPE";
        public static final String HSAE_TFR_PROGRAM_TYPE = "HSAE.TFR.PROGRAM_TYPE";
        public static final String HSAE_ACCOUNT_FIELD_ATTRIBUTE = "HSAE.ACCOUNT.FIELD_ATTRIBUTE";
        public static final String HSAE_DELIVERY_ACCOUNT_STATUS = "HSAE.DELIVERY.ACCOUNT_STATUS";

        public Code() {
        }
    }

    public static class RuleCode {
        public static final String AE_SUM_ACCOUNT_CODE = "HSAE.AE.SUM_ACCOUNT_CODE";
        public static final String AE_CODE_RULE = "HSAE.AE.BATCH_NUM_CODE";
        public static final String HSAE_TFR_TFR_BATCH_ID = "HSAE.TFR.TFR_BATCH_ID";
        public static final String HSAE_TFR_TFR_EVENT_ID = "HSAE.TFR.TFR_EVENT_ID";
        public static final String HSAE_DELIVERY_ACCOUNT_CODE = "HSAE.TFR.DELIVERY_ACCOUNT_CODE";
        public static final String HSAE_TFR_DELIVERY_CLEARING_NO = "HSAE.TFR.DELIVERY_CLEARING_NO";
        public static final String HSAE_TFR_SUM_ACCOUNT_NUM = "HSAE.ACCOUNT.SUM_ACCOUNT_NUM";
        public static final String HSAE_TFR_TFR_SUM_ACCOUNT_ID = "HSAE.TFR.TFR_SUM_ACCOUNT_ID";
        public static final String HSAE_TFR_TFR_SUM_TEMP_ID = "HSAE.TFR.TFR_SUM_TEMP_ID";
        //推送凭证信息至EBS批次号生成规则编码
        public static final String HSAE_TFR_EBS_BATCH_NUM = "HSAE.TFR.EBS_BATCH_NUM";
        //推送IPV信息至EBS批次号生成规则编码
        public static final String HSAP_TFR_EBS_IPV_NUM = "HSAP.TFR.EBS_IPV_NUM";


        public RuleCode() {
        }
    }

    public static class RedisLockObject {
        public static final String HSAE_AE_REDIS_LOCK_PREFIX = "hscs:lock:";
        public static final String HSAE_AE_TFR_INTERFACE_KEY = "hscs:lock:hsae_tfr_interface:tfrInterfaceId:";
        public static final String HSAE_AE_TFR_SUM_ACCOUNTS_KEY = "hscs:lock:hsae_tfr_sum_accounts:tfrSumAccountId:";
        public static final String HSAE_AE_TFR_BATCH_EVENTS_KEY = "hscs:lock:hsae_tfr_batch_events:tfrEventBatchId:";
        public static final String HSAE_AE_TFR_EVENTS_KEY = "hscs:lock:hsae_tfr_events:tfrEventId:";
        public static final String HSAE_AE_TFR_RECORDS_KEY = "hsae:lock:hsae_tfr_delivery_records:recordId:";

        public RedisLockObject() {
        }
    }

    public static class SummaryStage {
        public static final String FIRST_SUMMARY = "FIRST_SUMMARY";
        public static final String SECOND_SUMMARY = "SECOND_SUMMARY";
        public static final String SUMMARY_COMPLETED = "SUMMARY_COMPLETED";

        public SummaryStage() {
        }
    }

    public static class SummaryType {
        public static final String NO_SUMMARY = "NO_SUMMARY";
        public static final String FIRST_SUMMARY = "FIRST_SUMMARY";
        public static final String SECOND_SUMMARY = "SECOND_SUMMARY";
        public static final String THIRD_SUMMARY = "THIRD_SUMMARY";

        public SummaryType() {
        }
    }

    public static class MaskCodeRegex {
        public static final String YYYY = "[1-9]\\d{3}";
        public static final String YYYYMM = "^[1-9]\\d{3}-(([0][1-9])|([1][0-2]))$";
        public static final String YYYYMMDD = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|\n((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|\n((0[48]|[2468][048]|[3579][26])00))-02-29)$";
        public static final String YYYYMMDD_HHMMSS = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|\n((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|\n((0[48]|[2468][048]|[3579][26])00))-02-29))\n\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        public static final String SPLASH_YYYYMMDD = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})\\/(((0[13578]|1[02])\\/(0[1-9]|[12][0-9]|3[01]))|\n((0[469]|11)\\/(0[1-9]|[12][0-9]|30))|(02\\/(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|\n((0[48]|[2468][048]|[3579][26])00))\\/02\\/29)$";

        public MaskCodeRegex() {
        }
    }

    public static class ConfigRedisKey {
        public static final String PREFIX = "hscs:hsae:config:BATCH:";
        public static final String ACCOUNT = "account";
        public static final String CATEGORY = "category";
        public static final String RULE = "rule";
        public static final String MAPPING = "mapping";
        public static final String FILTER = "filter";
        public static final String SOURCE = "source";
        public static final String EVENT = "event";

        public ConfigRedisKey() {
        }
    }

    public static class ProcessFlag {
        public static final String S = "S";
        public static final String Y = "Y";
        public static final String N = "N";

        public ProcessFlag() {
        }
    }

    public static class TableField {
        public static final String ACCOUNTING_STATUS = "ACCOUNTING_STATUS";
        public static final String ACCOUNTING_REMARKS = "ACCOUNTING_REMARKS";

        public TableField() {
        }

        public static class TfrDeliveryRecords {
            public static final String RECORD_ID = "RECORD_ID";
            public static final String ACCOUNTING_FLAG = "ACCOUNTING_FLAG";
            public static final String CERTIFICATE_ID = "CERTIFICATE_ID";
            public static final String CERTIFICATE_NUM = "CERTIFICATE_NUM";
            public static final String ACCOUNTING_REMARKS = "ACCOUNTING_REMARKS";

            public TfrDeliveryRecords() {
            }
        }

        public static class TfrEventsAccounts {
            public static final String TFR_EVENT_ID = "TFR_EVENT_ID";

            public TfrEventsAccounts() {
            }
        }

        public static class TfrBatchAccounts {
            public static final String TFR_EVENT_BATCH_ID = "TFR_EVENT_BATCH_ID";

            public TfrBatchAccounts() {
            }
        }

        public static class TfrSumAccounts {
            public static final String TFR_SUM_ACCOUNT_ID = "TFR_SUM_ACCOUNT_ID";

            public TfrSumAccounts() {
            }
        }

        public static class TfrDtlAccounts {
            public static final String TFR_DTL_ACCOUNT_ID = "TFR_DTL_ACCOUNT_ID";

            public TfrDtlAccounts() {
            }
        }
    }

    public static class TableName {
        public static final String INTERFACE_TABLE = "HSAE_TFR_INTERFACE";
        public static final String INTERFACE_LINE_TABLE = "HSAE_TFR_LINE_INTERFACE";
        public static final String TFR_DTL_ACCOUNTS = "HSAE_TFR_DTL_ACCOUNTS";
        public static final String TFR_SUM_ACCOUNTS = "HSAE_TFR_SUM_ACCOUNTS";
        public static final String TFR_BATCH_ACCOUNTS = "HSAE_TFR_BATCH_EVENTS";
        public static final String TFR_EVENTS_ACCOUNTS = "HSAE_TFR_EVENTS";
        public static final String HSAE_TFR_DELIVERY_RECORDS = "HSAE_TFR_DELIVERY_RECORDS";

        public TableName() {
        }
    }

    public static final class DeliveryStatus {
        public static final String DELIVERY_STATUS_D = "D";
        public static final String DELIVERY_STATUS_E = "E";
        public static final String DELIVERY_STATUS_N = "N";
        public static final String DELIVERY_STATUS_S = "S";
        public static final String DELIVERY_STATUS_P = "P";

        public DeliveryStatus() {
        }
    }

    public static final class RollBackRange {
        public static final String ALL_ERROR_ROLLBACK = "ALL_ERROR_ROLLBACK";
        public static final String ACCOUNTED_ABNORMAL = "ACCOUNTED_ABNORMAL";

        public RollBackRange() {
        }
    }

    public static final class MaskCode {
        public static final String YYYY = "yyyy";
        public static final String YYYYMM = "yyyy-MM";
        public static final String YYYYMMDD = "yyyy-MM-dd";
        public static final String YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
        public static final String SPLASH_YYYYMMDD = "yyyy/MM/dd";
        public static final String SPLASH_YYYYMMDD_HHMMSS = "yyyy/MM/dd HH:mm:ss";
        public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

        public MaskCode() {
        }
    }

    public static final class BasicTable {
        public static final String HSAE_TFR_INTERFACE = "HSAE_TFR_INTERFACE";

        public BasicTable() {
        }
    }

    public static final class ValueType {
        public static final String DATE = "DATE";
        public static final String DATETIME = "DATETIME";
        public static final String NUMBER = "NUMBER";
        public static final String VARCHAR = "VARCHAR";

        public ValueType() {
        }
    }

    public static final class PushValueFrom {
        public static final String CONSTANT = "CONSTANT";
        public static final String ACCOUNT_DATE = "ACCOUNT_DATE";
        public static final String ACCOUNT_FILED = "ACCOUNT_FILED";
        public static final String ACCOUNT_SUMMARY_FILED = "ACCOUNT_SUMMARY";

        public PushValueFrom() {
        }
    }

    public static final class DbValueType {
        public static final String DATETIME = "DATETIME";
        public static final String DATE = "DATE";
        public static final String BIGINT = "BIGINT";
        public static final String DECIMAL = "DECIMAL";
        public static final String VARCHAR = "VARCHAR";
        public static final String LONGTEXT = "LONGTEXT";

        public DbValueType() {
        }
    }

    public static final class ColumnType {
        public static final String SOURCE = "SOURCE";
        public static final String TARGET = "TARGET";

        public ColumnType() {
        }
    }

    public static final class GroupingMethod {
        public static final String GROUPING = "GROUPING";
        public static final String ACCUMULATE = "ACCUMULATE";

        public GroupingMethod() {
        }
    }

    public static final class AccountingStatus {

        public static final String NEW = "NEW";
        public static final String PRE_VERIFIED_ERROR = "PRE_VERIFIED_ERROR";
        public static final String VERIFIED = "VERIFIED";
        public static final String VERIFIED_ERROR = "VERIFIED_ERROR";
        public static final String GENERATING = "GENERATING";
        public static final String GENERATED = "GENERATED";
        public static final String GENERATED_ERROR = "GENERATED_ERROR";
        public static final String ACCOUNTING = "ACCOUNTING";
        public static final String ACCOUNTED = "ACCOUNTED";
        public static final String ACCOUNTED_ABNORMAL = "ACCOUNTED_ABNORMAL";
        public static final String ACCOUNTED_ERROR = "ACCOUNTED_ERROR";
        public static final String REV_PRE_VERIFIED_ERROR = "REV_PRE_VERIFIED_ERROR";
        public static final String REV_VERIFIED = "REV_VERIFIED";
        public static final String REV_VERIFIED_ERROR = "REV_VERIFIED_ERROR";
        public static final String REV_GENERATED = "REV_GENERATED";
        public static final String REV_GENERATED_ERROR = "REV_GENERATED_ERROR";
        public static final String REV_ACCOUNTING = "REV_ACCOUNTING";
        public static final String REV_ACCOUNTED = "REV_ACCOUNTED";
        public static final String REV_ACCOUNTED_ABNORMAL = "REV_ACCOUNTED_ABNORMAL";
        public static final String REV_ACCOUNTED_ERROR = "REV_ACCOUNTED_ERROR";

        public static final String FORWARD_ACCOUNT = "1";
        public static final String REV_ACCOUNT = "-1";

        public AccountingStatus() {
        }
    }

    public static final class ValueFrom {
        public static final String CONSTANT = "CONSTANT";
        public static final String FORMULA = "FORMULA";
        public static final String SEQUENCE = "SEQUENCE";
        public static final String SOURCE = "SOURCE";
        public static final String TARGET = "TARGET";

        public ValueFrom() {
        }
    }

    public static final class DeliveryAmount {
        public static final int DEFAULT_BATCH_COUNT_1000 = 1000;

        public DeliveryAmount() {
        }
    }

    public static final class FieldAttribute {
        public static final String DR_AMOUNT = "DR_AMOUNT";
        public static final String CR_AMOUNT = "CR_AMOUNT";
        public static final String DR_BASE_AMOUNT = "DR_BASEAMOUNT";
        public static final String CR_BASE_AMOUNT = "CR_BASEAMOUNT";

        public FieldAttribute() {
        }
    }

    public static final class MappingColumnType {
        public static final String AE_COLUMN_TYPE_SOURCE = "SOURCE";
        public static final String AE_COLUMN_TYPE_TARGET = "TARGET";
        public static final String AE_COLUMN_TYPE_CONSTANT = "CONSTANTS";

        public MappingColumnType() {
        }
    }

    public static final class CreateAccountDirection {
        public static final String REV_RUN = "REV_RUN";
        public static final String NEW_RUN = "NEW_RUN";

        public CreateAccountDirection() {
        }
    }

    public static final class FeedAccountStatus {
        public static final String ACCOUNTED_SUCCESS = "ACCOUNTED_SUCCESS";
        public static final String ACCOUNTED_ERROR = "ACCOUNTED_ERROR";
        public static final String UN_ACCOUNTED = "UN_ACCOUNTED";

        public FeedAccountStatus() {
        }
    }

    public static final class Punctuation {
        public static final String COMMA = ",";
        public static final String STRING_STAR = "*";
        public static final String ENTER_STR = "\n";
        public static final String TAB_STR = "\t";
        public static final String SPACE_STR = " ";
        public static final String STRING_BLANK = "";
        public static final String POINT = ".";

        public Punctuation() {
        }
    }

    public static final class ExcelConstants {
        public static final String XLS = "XLS";
        public static final String XLSX = "XLSX";
        public static final String XLS_LOWERCASE = "xls";
        public static final String POINT_XLS_LOWERCASE = ".xls";

        public ExcelConstants() {
        }
    }

    public static final class ExportType {
        public static final String EXCEL = "EXCEL";

        public ExportType() {
        }
    }

    public static final class ImportTemplate {
        public static final String TEMPLATE_CODE_AP_SALARY = "AP_SALARY";
        public static final String TEMPLATE_CODE_NC_ACCOUNTS_TRANSFORM = "NC_ACCOUNTS_TRANSFORM";

        public ImportTemplate() {
        }
    }

}
