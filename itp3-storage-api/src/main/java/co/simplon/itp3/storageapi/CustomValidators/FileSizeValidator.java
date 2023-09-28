package co.simplon.itp3.storageapi.CustomValidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class FileSizeValidator implements
	ConstraintValidator<FileSize, MultipartFile> {

    private static final long KB = 1000;

    private long maxSizeInKB;

    @Override
    public void initialize(FileSize fileSize) {
	this.maxSizeInKB = fileSize.maxSizeInKB();
    }

    @Override
    public boolean isValid(MultipartFile value,
	    ConstraintValidatorContext context) {
	if (value == null) {
	    return true;
	}
	return value.getSize() < (maxSizeInKB * KB);
    }

}
