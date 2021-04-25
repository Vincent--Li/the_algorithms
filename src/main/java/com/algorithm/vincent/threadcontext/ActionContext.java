package com.algorithm.vincent.threadcontext;



/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ActionContext {
    private static final ThreadLocal<Context> context = ThreadLocal.withInitial(Context::new);

    public static Context get(){
        return context.get();
    }

    static class Context {
        private Configuration configuration;
        private OtherResource otherResource;

        public Configuration getConfiguration() {
            return configuration;
        }

        public Context setConfiguration(Configuration configuration) {
            this.configuration = configuration;
            return this;
        }

        public OtherResource getOtherResource() {
            return otherResource;
        }

        public Context setOtherResource(OtherResource otherResource) {
            this.otherResource = otherResource;
            return this;
        }
    }
}
