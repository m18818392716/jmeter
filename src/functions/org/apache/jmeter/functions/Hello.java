package org.apache.jmeter.functions;

/**
 * @author Susanna
 * @date 2021/6/17 12:01
 */
import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import java.util.Collection;
import java.util.List;

public class Hello extends AbstractFunction {
    /**
     * <p><b>
     * N.B. execute() should be synchronized if function is operating with non-thread-safe
     * objects (e.g. operates with files).
     * </b></p>
     * JMeter ensures setParameters() happens-before execute(): setParameters is executed in main thread,
     * and worker threads are started after that.
     *
     * @param previousResult
     * @param currentSampler
     * @see Function#execute(SampleResult, Sampler)
     */
    private static final String KEY = "__Hello";
    @Override
    public String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
        return "Hello Word!";
    }

    /**
     * Note: This is always called even if no parameters are provided
     * (versions of JMeter after 2.3.1)
     *
     * @param parameters
     * @see Function#setParameters(Collection)
     */
    @Override
    public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {

    }

    /**
     * @see Function#getReferenceKey()
     */
    @Override
    public String getReferenceKey() {
        return KEY;
    }

    /**
     * Return a list of strings briefly describing each parameter your function
     * takes. Please use JMeterUtils.getResString(resource_name) to grab a
     * resource string. Otherwise, your help text will be difficult to
     * internationalize.
     * <p>
     * This list is not optional. If you don't wish to write help, you must at
     * least return a List containing the correct number of blank strings, one
     * for each argument.
     *
     * @return List with brief descriptions for each parameter the function takes
     */
    @Override
    public List<String> getArgumentDesc() {
        return null;
    }
}