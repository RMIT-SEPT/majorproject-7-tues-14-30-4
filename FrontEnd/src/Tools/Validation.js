export function validateFormData(input, expect)
{
    if (input !== expect){
      throw new Error('Expecting 4');
    }
    if (input === expect)
    {
        return input;
    }
    
}