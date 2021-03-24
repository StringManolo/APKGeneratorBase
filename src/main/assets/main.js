// Atajos
const $ = selector => document.querySelector(selector);
const ael = (elem, ev, cb) => elem.addEventListener(ev, e => cb(e));

// Métodos nativos expuestos mediante una interfaz
const vibrate = ms => Android.Vibrate(ms);

// Codigo De La Web:
const textareaEncode = $("#encode");
const textareaDecode = $("#decode");
const buttonTextareaEncode = $("#bEncode");
const buttonTextareaDecode = $("#bDecode");

ael(buttonTextareaEncode, "click", () => {
  vibrate(500);
  textareaDecode.value = btoa(textareaEncode.value);
});

ael(buttonTextareaDecode, "click", () => {
  vibrate(250);
  textareaEncode.value = atob(textareaDecode.value);
});
