package optifine;

import java.lang.reflect.Field;

public class FieldLocatorName implements IFieldLocator
{
    private ReflectorClass reflectorClass;
    private String targetFieldName;

    public FieldLocatorName(ReflectorClass p_i38_1_, String p_i38_2_)
    {
        reflectorClass = null;
        this.reflectorClass = p_i38_1_;
        this.targetFieldName = p_i38_2_;
    }

    public Field getField()
    {
        Class oclass = this.reflectorClass.getTargetClass();

        if (oclass == null)
        {
            return null;
        }
        else
        {
            try
            {
                Field field = oclass.getDeclaredField(this.targetFieldName);
                field.setAccessible(true);
                return field;
            }
            catch (NoSuchFieldException var3)
            {
                Config.log("(Reflector) Field not present: " + oclass.getName() + "." + this.targetFieldName);
                return null;
            } catch (Throwable securityexception)
            {
                securityexception.printStackTrace();
                return null;
            }
        }
    }
}
