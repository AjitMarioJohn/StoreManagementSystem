package com.sms.itemMgmt.domain.useCases;

public abstract class UseCase<I extends UseCase.InputValues, O extends UseCase.OutputValues> {
    public abstract O execute(I input) throws Exception;

    public interface InputValues {
    }

    public interface OutputValues {
    }
}
