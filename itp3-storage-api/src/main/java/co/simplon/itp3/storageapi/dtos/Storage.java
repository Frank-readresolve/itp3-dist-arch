package co.simplon.itp3.storageapi.dtos;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import co.simplon.itp3.storageapi.CustomValidators.FileSize;
import co.simplon.itp3.storageapi.CustomValidators.FileType;

public class Storage {

    @NotNull
    @FileSize(maxSizeInKB = 100)
    @FileType
    private MultipartFile file;

    public Storage() {
    }

    public MultipartFile getFile() {
	return file;
    }

    public void setFile(MultipartFile file) {
	this.file = file;
    }

    @Override
    public String toString() {
	return " {file=" + file + "}";
    }
}
