//public class CommonClass {
//
//    import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import configuration.api.ccg.*;
//import io.restassured.response.Response;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;import
//
//import static com.api.enums.ccg.ContentType.*;
//import static com.api.enums.ccg.Headers.*;
//import static com.api.enums.ccg.Merchant.*;
//import static com.api.enums.ccg.UpStreamEnv.*;
//import static com.api.enums.ccg.auth.Scope.*;
//import static com.ui.Baseclass.*;
//import static configuration.ConfigLoader.*;
//import static io.restassured.RestAssured.given;
//import static org.apache.http.HttpHeaders.*;
//import static utils.UtilLoader.*;
//
//    public class CommonClass {
//
//        public final String grantType = "client_credentials";
//
//        String SALE = "SALE";
//        String PRE_AUTH = "PRE_AUTH";
//
//        public static String DEFAULT_PRIVACY_URL = "https://www.optum.com/privacy-policy.html";
//        public static String DEFAULT_PRIVACY_URL_EN_LOCALE = "https://www.optum.com/en/privacy-policy.html";
//        public static String DEFAULT_SENDER_EMAIL = "no-reply@ccg.optum.com";
//
//        public static String PAYMENT_TYPE;
//
//        public String ClientID, ClientSecret, Scope, MerchantID;
//
//        final Infusion infusion = ccgConfig.getInfusion();
//        final Solutran solutran = ccgConfig.getSolutran();
//        final Uhcifp uhcifp = ccgConfig.getUhcifp();
//        final Optumrx optumRx = ccgConfig.getOptumrx();
//        final OptumRxHome optumRxHome = ccgConfig.getOptumrxHome();
//        final UHC uhc = ccgConfig.getUhc();
//
//        public HashMap<String, String> getHeader(boolean defaultClientId) {
//            HashMap<String, String> header = new HashMap<>();
//            header.put(CONTENT_TYPE, MEDIA_TYPE_APPLICATION_JSON);
//            header.put(X_UPSTREAM_ENV, getUpStreamEnv());
//            header.put(AUTHORIZATION, "Bearer " + generateHSPToken("Merchant", defaultClientId));
//            header.put(X_MERCHANT_ID, getMerchantID());
//            return header;
//        }
//
//        private String getUpStreamEnv() {
//            switch (Environment) {
//                case "stg":
//                    return UPSTREAM_ENV_STAGE;
//                case "test":
//                    return UPSTREAM_ENV_TEST;
//                case "dev":
//                default:
//                    return UPSTREAM_ENV_DEV;
//            }
//        }
//
//        public HashMap<String, String> getHeader(String scope, boolean defaultClientId) {
//            HashMap<String, String> header = new HashMap<>();
//            header.put(CONTENT_TYPE, MEDIA_TYPE_APPLICATION_JSON);
//            header.put(X_UPSTREAM_ENV, getUpStreamEnv());
//            header.put(AUTHORIZATION, "Bearer " + generateHSPToken(scope, defaultClientId));
//            header.put(X_MERCHANT_ID, getMerchantID());
//            return header;
//        }
//
//        public HashMap<String, String> getHeader(String scope, boolean defaultClientId, String source) {
//            HashMap<String, String> header = new HashMap<>();
//            header.put(CONTENT_TYPE, MEDIA_TYPE_APPLICATION_JSON);
//            header.put(X_UPSTREAM_ENV, getUpStreamEnv());
//            header.put(AUTHORIZATION, "Bearer " + generateHSPToken(scope, defaultClientId));
//            header.put(X_MERCHANT_ID, getMerchantID());
//            header.put(X_SOURCE, source);
//            return header;
//        }
//
//        public HashMap<String, String> getWidgetHeader(boolean defaultClientId, String customerType) {
//            HashMap<String, String> header = new HashMap<>();
//            header.put(CONTENT_TYPE, MEDIA_TYPE_APPLICATION_JSON);
//            header.put(X_UPSTREAM_ENV, getUpStreamEnv());
//            header.put(AUTHORIZATION, "Bearer " + generateHSPToken("Merchant", defaultClientId));
//            header.put(X_MERCHANT_ID, getMerchantID());
//            header.put(X_CCG_WIDGET_VERSION, getWidgetVersion());
//            if (customerType.equalsIgnoreCase("Customer"))
//                header.put(X_CUSTOMER_ID, dataUtils.getValue("walletCustomerId"));
//            else if (customerType.equalsIgnoreCase("Guest"))
//                header.put(X_CUSTOMER_ID, "guest");
//            else
//                header.put(X_CUSTOMER_ID, uuidUtil.getRandomUUID());
//            header.put(X_CHECKOUT_ID, dataUtils.getValue("sessionId"));
//            return header;
//        }
//
//        public HashMap<String, String> getWidgetHeaderForUserScope(String customerType) {
//            HashMap<String, String> header = new HashMap<>();
//            header.put(CONTENT_TYPE, MEDIA_TYPE_APPLICATION_JSON);
//            header.put(X_UPSTREAM_ENV, getUpStreamEnv());
//            header.put(AUTHORIZATION, "Bearer " + dataUtils.getValue("USER_SCOPE_SESSION_TOKEN"));
//            header.put(X_MERCHANT_ID, getMerchantID());
//            header.put(X_CCG_WIDGET_VERSION, getWidgetVersion());
//            if (customerType.equalsIgnoreCase("Customer"))
//                header.put(X_CUSTOMER_ID, dataUtils.getValue("walletCustomerId"));
//            else if (customerType.equalsIgnoreCase("Guest"))
//                header.put(X_CUSTOMER_ID, "guest");
//            else
//                header.put(X_CUSTOMER_ID, uuidUtil.getRandomUUID());
//            header.put(X_CHECKOUT_ID, dataUtils.getValue("sessionId"));
//            return header;
//        }
//
//
//
//        public void setMerchantID() {
//            switch (MerchantName.toUpperCase()) {
//                case INFUSION:
//                    MerchantID = infusion.getMerchantId();
//                    break;
//                case SOLUTRAN:
//                    MerchantID = solutran.getMerchantId();
//                    break;
//                case OPTUMRX:
//                    MerchantID = optumRx.getMerchantId();
//                    break;
//                case OPTUMRXHOME:
//                    MerchantID = optumRxHome.getMerchantId();
//                    break;
//                case UHC:
//                    MerchantID = uhc.getMerchantId();
//                    break;
//                case UHCIFP:
//                    MerchantID = uhcifp.getMerchantId();
//                    break;
//                default:
//                    throw new RuntimeException("Invalid Merchant");
//            }
//        }
//
//        public void setMerchantID(String merchantName) {
//            MerchantName = merchantName;
//            switch (merchantName.toUpperCase()) {
//                case INFUSION:
//                    MerchantID = infusion.getMerchantId();
//                    break;
//                case SOLUTRAN:
//                    MerchantID = solutran.getMerchantId();
//                    break;
//                case OPTUMRX:
//                    MerchantID = optumRx.getMerchantId();
//                    break;
//                case OPTUMRXHOME:
//                    MerchantID = optumRxHome.getMerchantId();
//                    break;
//                case UHC:
//                    MerchantID = uhc.getMerchantId();
//                    break;
//                case UHCIFP:
//                    MerchantID = uhcifp.getMerchantId();
//                    break;
//                default:
//                    throw new RuntimeException("Invalid Merchant");
//            }
//        }
//
//        public String getCCGEndpoint() {
//            return ccgConfig.getHost() + "/" + ccgConfig.getResourceGroup();
//        }
//
//        public void setClientID(boolean defaultClientId) {
//            if (defaultClientId)
//                ClientID = ccgConfig.getDefaultClientId();
//            else {
//                switch (MerchantName.toUpperCase()) {
//                    case INFUSION:
//                        ClientID = infusion.getClientId();
//                        break;
//                    case SOLUTRAN:
//                        ClientID = solutran.getClientId();
//                        break;
//                    case OPTUMRX:
//                        ClientID = optumRx.getClientId();
//                        break;
//                    case OPTUMRXHOME:
//                        ClientID = optumRxHome.getClientId();
//                        break;
//                    case UHC:
//                        ClientID = uhc.getClientId();
//                        break;
//                    case UHCIFP:
//                        ClientID = uhcifp.getClientId();
//                        break;
//                    default:
//                        throw new RuntimeException("Invalid Merchant");
//                }
//            }
//        }
//
//        public String getMerchantID() {
//            return MerchantID;
//        }
